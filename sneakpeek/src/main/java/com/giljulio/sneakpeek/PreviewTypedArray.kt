package com.giljulio.sneakpeek

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue

class PreviewTypedArray(
        private val context: Context,
        wrapped: TypedArray,
        private val attrs: IntArray,
        private val set: AttributeSet) : TypedArrayWrapper(wrapped) {

    companion object {
        val androidNamespace = "http://schemas.android.com/apk/res/android"
    }

    override fun getText(index: Int): CharSequence {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.getString(resId)
            }

            return set.getAttributeValue(androidNamespace, attribute)
        }
        return super.getText(index)
    }

    override fun getString(index: Int): String {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.getString(resId)
            }

            return set.getAttributeValue(androidNamespace, attribute)
        }
        return super.getString(index)
    }

    override fun getBoolean(index: Int, defValue: Boolean): Boolean {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getBoolean(resId)
            }

            return set.getAttributeBooleanValue(androidNamespace, attribute, defValue)
        }
        return super.getBoolean(index, defValue)
    }

    override fun getInt(index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getInteger(resId)
            }

            return set.getAttributeIntValue(androidNamespace, attribute, defValue)
        }
        return super.getInt(index, defValue)
    }

    override fun getFloat(index: Int, defValue: Float): Float {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getDimension(resId)
            }

            return set.getAttributeFloatValue(androidNamespace, attribute, defValue)
        }
        return super.getFloat(index, defValue)
    }

    override fun getColor(index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            // The layout might be referencing a theme attribute.
            val resId = resolveResId(attribute)
            if (resId != 0) {
                return ColorUtil.getColor(context, resId)
            }

            val attributeValue = set.getAttributeValue(androidNamespace, attribute)
            return ColorUtil.getColor(attributeValue)
        }
        return super.getColor(index, defValue)
    }

    override fun getColorStateList(index: Int): ColorStateList {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {
            val resId = resolveResId(attribute)
            if (resId != 0) {
                return ColorUtil.getColorStateList(context.resources, resId, context.theme)
            }
        }
        return super.getColorStateList(index)
    }

    override fun getInteger(index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getInteger(resId)
            }

            return set.getAttributeIntValue(androidNamespace, attribute, defValue)
        }
        return super.getInteger(index, defValue)
    }

    override fun getDimension(index: Int, defValue: Float): Float {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getDimension(resId)
            }

            return set.getAttributeFloatValue(androidNamespace, attribute, defValue)
        }
        return super.getDimension(index, defValue)
    }

    override fun getDimensionPixelOffset(index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getDimensionPixelOffset(resId)
            }
        }
        return super.getDimensionPixelOffset(index, defValue)
    }

    override fun getDimensionPixelSize(index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getDimensionPixelSize(resId)
            }
        }
        return super.getDimensionPixelSize(index, defValue)
    }

    override fun getLayoutDimension(index: Int, name: String): Int {
        return super.getLayoutDimension(index, name)
    }

    override fun getLayoutDimension(index: Int, defValue: Int): Int {
        return super.getLayoutDimension(index, defValue)
    }

    override fun getResourceId(index: Int, defValue: Int): Int {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return resId
            }
        }
        return super.getResourceId(index, defValue)
    }

    override fun getDrawable(index: Int): Drawable {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {
            val resId = resolveResId(attribute)
            if (resId != 0) {
                return DrawableUtil.getDrawable(context.resources, resId, context.theme)
            }
        }
        return super.getDrawable(index)
    }

    override fun getTextArray(index: Int): Array<CharSequence> {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.resources.getStringArray(resId)
                        .map { it!! }
                        .toTypedArray()
            }
        }
        return super.getTextArray(index)
    }

    override fun getValue(index: Int, outValue: TypedValue): Boolean {
        val attribute = getAttributeName(index)
        if (shouldOverrideAttribute(attribute)) {

            val resId = resolveResId(attribute)
            if (resId != 0) {
                return context.theme.resolveAttribute(resId, outValue, true)
            }
        }
        return super.getValue(index, outValue)
    }


    private fun shouldOverrideAttribute(name: String): Boolean {
        return set.getAttributeValue(androidNamespace, name) != null
    }

    private fun getAttributeName(index: Int): String {
        return context.resources.getResourceEntryName(attrs[index])
    }


    private fun resolveResId(attribute: String): Int {
        // resolve attribute
        var identifier = set.getAttributeResourceValue(androidNamespace, attribute, 0)
        if (identifier != 0) {

            // check if it is an attr ref
            val attributeValue = set.getAttributeValue(androidNamespace, attribute)
            val attrRes = context.resources.getIdentifier(attributeValue.substring(1), null, null)
            if (attrRes != 0) {
                identifier = attrRes
            }

            // resolve res id
            val tempValue = TypedValue()
            if (context.theme.resolveAttribute(identifier, tempValue, true)) {
                return tempValue.resourceId
            }

            return identifier
        }
        return 0
    }
}