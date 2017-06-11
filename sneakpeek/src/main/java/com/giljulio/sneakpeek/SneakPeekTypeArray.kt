package com.giljulio.sneakpeek

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.StyleableRes
import android.util.AttributeSet

class SneakPeekTypeArray private constructor(
        private val context: Context,
        private val wrapped: TypedArray,
        private val attrs: IntArray,
        private val set: AttributeSet) {

    val androidNamespace = "http://schemas.android.com/apk/res/android"
    val resAutoNamespace = "http://schemas.android.com/apk/res-auto"
    val resourceDelegate = ResourceDelegate(context)

    companion object {

        fun obtainStyledAttributes(context: Context,
                                   set: AttributeSet?,
                                   attrs: IntArray,
                                   defStyleAttr: Int = 0,
                                   defStyleRes: Int = 0): SneakPeekTypeArray {

            return SneakPeekTypeArray(context, context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes), attrs, set!!) //TODO fix this
        }
    }

    fun hasValue(@StyleableRes index: Int): Boolean = wrapped.hasValue(index)



    fun getString(@StyleableRes index: Int): String {
        val attribute = getAttributeName(index)
        if (!useNativeImpl(attribute)) {

            // The layout might be referencing a theme attribute.
            if (unwrap(attribute) != 0) {
                return context.getString(unwrap(attribute))
            }
            return set.getAttributeValue(androidNamespace, attribute)
        }
        return wrapped.getString(index)
    }

    @ColorInt
    fun getColor(@StyleableRes index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (!useNativeImpl(attribute)) {

            // The layout might be referencing a theme attribute.
            val attributeValue = set.getAttributeValue(androidNamespace, attribute)
            if (!attributeValue.startsWith("#")) {
                return resourceDelegate.getColor(unwrap(attribute))
            }

            return Color.parseColor(attributeValue)
        }
        return wrapped.getColor(index, defValue)
    }


    fun recycle() {
        wrapped.recycle()
    }

    private fun useNativeImpl(name: String): Boolean =
            set.getAttributeValue(androidNamespace, name) == null

    private fun getAttributeName(index: Int) = context.resources.getResourceEntryName(attrs[index])

    private fun unwrap(attribute: String?): Int {
        val attributeValue = set.getAttributeValue(androidNamespace, attribute)
        var resId = set.getAttributeResourceValue(androidNamespace, attribute, 0)
        if (resId != 0) {
            resId = resourceDelegate.unwrapAttribute(resId, attributeValue)
            return resourceDelegate.unwrapIdentifier(resId)
        }
        return resId
    }

}
