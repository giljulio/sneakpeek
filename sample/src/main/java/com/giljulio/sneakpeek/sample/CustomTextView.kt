package com.giljulio.sneakpeek.sample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import com.giljulio.sneakpeek.SneakPeekTypeArray

class CustomTextView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : TextView(context, attrs, defStyleAttr) {

    init {
        val a = SneakPeekTypeArray.obtainStyledAttributes(context, attrs, R.styleable.CustomTextView, defStyleAttr, 0)

//        if(a.hasValue(R.styleable.CustomView_custom_background)) {
        text = (a.getString(R.styleable.CustomTextView_custom_title))
        setBackgroundColor(a.getColor(R.styleable.CustomTextView_custom_background, Color.YELLOW));
//        }

        a.recycle()
    }


}
