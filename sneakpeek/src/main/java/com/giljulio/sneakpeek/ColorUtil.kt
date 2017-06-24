package com.giljulio.sneakpeek

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes

/**
 * Created by Gil on 23/06/2017.
 */

object ColorUtil {

    /**
     * Returns the color value represented by the given string value
     * @param value the color value
     * *
     * @return the color as an int
     * *
     * @throws NumberFormatException if the conversion failed.
     */
    fun getColor(value: String?): Int {
        var value = value
        if (value != null) {
            if (!value.startsWith("#")) {
                if (value.startsWith("?")) {
                    throw NumberFormatException(String.format(
                            "Attribute '%s' not found. Are you using the right theme?", value))
                }
                throw NumberFormatException(
                        String.format("Color value '%s' must start with #", value))
            }

            value = value.substring(1)

            // make sure it's not longer than 32bit
            if (value.length > 8) {
                throw NumberFormatException(String.format(
                        "Color value '%s' is too long. Format is either" + "#AARRGGBB, #RRGGBB, #RGB, or #ARGB",
                        value))
            }

            if (value.length == 3) { // RGB format
                val color = CharArray(8)
                color[1] = 'F'
                color[0] = color[1]
                color[3] = value[0]
                color[2] = color[3]
                color[5] = value[1]
                color[4] = color[5]
                color[7] = value[2]
                color[6] = color[7]
                value = String(color)
            } else if (value.length == 4) { // ARGB format
                val color = CharArray(8)
                color[1] = value[0]
                color[0] = color[1]
                color[3] = value[1]
                color[2] = color[3]
                color[5] = value[2]
                color[4] = color[5]
                color[7] = value[3]
                color[6] = color[7]
                value = String(color)
            } else if (value.length == 6) {
                value = "FF" + value
            }

            // this is a RRGGBB or AARRGGBB value

            // Integer.parseInt will fail to parse strings like "ff191919", so we use
            // a Long, but cast the result back into an int, since we know that we're only
            // dealing with 32 bit values.
            return java.lang.Long.parseLong(value, 16).toInt()
        }

        throw NumberFormatException()
    }


    @ColorInt
    fun getColor(context: Context, @ColorRes resId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(resId)
        } else {
            return context.resources.getColor(resId, context.theme)
        }
    }

    @Throws(Resources.NotFoundException::class)
    fun getColorStateList(res: Resources, @ColorRes id: Int,
                          theme: Resources.Theme?): ColorStateList {
        if (SDK_INT >= 23) {
            return res.getColorStateList(id, theme)
        } else {
            @Suppress("DEPRECATION")
            return res.getColorStateList(id)
        }
    }
}
