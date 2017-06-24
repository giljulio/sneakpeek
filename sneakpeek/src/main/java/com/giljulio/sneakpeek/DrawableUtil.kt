package com.giljulio.sneakpeek

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.DrawableRes

object DrawableUtil {

    @Throws(Resources.NotFoundException::class)
    fun getDrawable(res: Resources, @DrawableRes id: Int,
                    theme: Resources.Theme?): Drawable {
        if (SDK_INT >= 21) {
            return res.getDrawable(id, theme)
        } else {
            @Suppress("DEPRECATION")
            return res.getDrawable(id)
        }
    }
}