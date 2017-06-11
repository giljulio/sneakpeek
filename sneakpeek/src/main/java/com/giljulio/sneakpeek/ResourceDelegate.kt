package com.giljulio.sneakpeek

import android.content.Context
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.util.TypedValue

class ResourceDelegate(val context: Context) {


    @ColorInt
    fun getColor(@ColorRes resId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(resId)
        } else {
            return context.resources.getColor(resId, context.theme)
        }
    }

    /**
     * Unwraps the identifier to the base identifier
     */
    fun unwrapIdentifier(original: Int): Int {
        var resId = original
        val tempValue = TypedValue()
        if (resId != 0 && context.theme.resolveAttribute(resId, tempValue, true)) {
            resId = tempValue.resourceId
        }
        return resId
    }

    /**
     * Unwraps an attribute identifier if we are supplied with "?attr/name"
     */
    fun unwrapAttribute(original: Int, attributeValue: String): Int {
        var resId = original
        if (resId == 0) {
            resId = context.resources.getIdentifier(attributeValue.substring(1), null, null)
        }
        return resId
    }}
