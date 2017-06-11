package com.giljulio.sneakpeek

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.StyleableRes
import android.util.AttributeSet
import android.util.TypedValue

class SneakPeekTypeArray private constructor(
        private val context: Context,
        private val wrapped: TypedArray,
        private val attrs: IntArray,
        private val set: AttributeSet) {

    val androidNamespace = "http://schemas.android.com/apk/res/android"
    val resAutoNamespace = "http://schemas.android.com/apk/res-auto"

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
            var resId = set.getAttributeResourceValue(androidNamespace, attribute, 0)
            if (resId != 0) {
                val tempValue = TypedValue()
                if (context.theme.resolveAttribute(resId, tempValue, true)) {
                    resId = tempValue.resourceId
                }

                return context.getString(resId)
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
            try {
                var resId = set.getAttributeResourceValue(androidNamespace, attribute, 0)
                if (resId != 0) {
                    val tempValue = TypedValue()
                    if (context.theme.resolveAttribute(resId, tempValue, true)) {
                        resId = tempValue.resourceId
                    }

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        return context.getColor(resId)
                    } else {
                        return context.resources.getColor(resId, context.theme)
                    }
                }

            } catch (e: Resources.NotFoundException) {

            }
            return set.getAttributeIntValue(androidNamespace, attribute, defValue)
        }
        return wrapped.getColor(index, defValue)
    }

    /*fun <T> getValue(@StyleableRes index: Int): T {
        val name = context.resources.getResourceEntryName(attrs[index])

        if (!useNativeImpl(index)) {
        }
        set.getAttributeValue(androidNamespace, name)
    }*/

    fun recycle() {

    }

    private fun useNativeImpl(name: String): Boolean =
            set.getAttributeValue(androidNamespace, name) == null

    private fun getAttributeName(index: Int) = context.resources.getResourceEntryName(attrs[index])

}
