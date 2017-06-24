package com.giljulio.sneakpeek

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.StyleableRes
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

interface SneakPeekTypedArray {

    companion object {
        @SuppressLint("Recycle")
        fun obtainStyledAttributes(view: View,
                                   set: AttributeSet?,
                                   attrs: IntArray,
                                   defStyleAttr: Int = 0,
                                   defStyleRes: Int = 0): SneakPeekTypedArray {

            val base = view.context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)
            if (view.isInEditMode) {
                return PreviewTypedArray(view.context, base, attrs, set!!)
            }
            return TypedArrayWrapper(base)
        }
    }


    /**
     * @see android.content.res.TypedArray.length
     */
    fun length(): Int

    /**
     * @see android.content.res.TypedArray.getIndexCount
     */
    fun getIndexCount(): Int

    /**
     * @see android.content.res.TypedArray.getIndex
     */
    fun getIndex(at: Int): Int

    /**
     * @see android.content.res.TypedArray.getResources
     */
    fun getResources(): Resources

    /**
     * @see android.content.res.TypedArray.getText
     */
    fun getText(@StyleableRes index: Int): CharSequence

    /**
     * @see android.content.res.TypedArray.getString
     */
    fun getString(@StyleableRes index: Int): String

    /**
     * @see android.content.res.TypedArray.getNonResourceString
     */
    fun getNonResourceString(@StyleableRes index: Int): String

    /**
     * @see android.content.res.TypedArray.getBoolean
     */
    fun getBoolean(@StyleableRes index: Int, defValue: Boolean): Boolean

    /**
     * @see android.content.res.TypedArray.getInt
     */
    fun getInt(@StyleableRes index: Int, defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getFloat
     */
    fun getFloat(@StyleableRes index: Int, defValue: Float): Float

    /**
     * @see android.content.res.TypedArray.getColor
     */
    fun getColor(@StyleableRes index: Int, @ColorInt defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getColorStateList
     */
    fun getColorStateList(@StyleableRes index: Int): ColorStateList

    /**
     * @see android.content.res.TypedArray.getInteger
     */
    fun getInteger(@StyleableRes index: Int, defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getDimension
     */
    fun getDimension(@StyleableRes index: Int, defValue: Float): Float

    /**
     * @see android.content.res.TypedArray.getDimensionPixelOffset
     */
    fun getDimensionPixelOffset(@StyleableRes index: Int, defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getDimensionPixelSize
     */
    fun getDimensionPixelSize(@StyleableRes index: Int, defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getLayoutDimension
     */
    fun getLayoutDimension(@StyleableRes index: Int, name: String): Int

    /**
     * @see android.content.res.TypedArray.getLayoutDimension
     */
    fun getLayoutDimension(@StyleableRes index: Int, defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getResourceId
     */
    fun getResourceId(@StyleableRes index: Int, defValue: Int): Int

    /**
     * @see android.content.res.TypedArray.getDrawable
     */
    fun getDrawable(@StyleableRes index: Int): Drawable

    /**
     * @see android.content.res.TypedArray.getTextArray
     */
    fun getTextArray(@StyleableRes index: Int): Array<CharSequence>

    /**
     * @see android.content.res.TypedArray.getValue
     */
    fun getValue(@StyleableRes index: Int, outValue: TypedValue): Boolean

    /**
     * @see android.content.res.TypedArray.getType
     */
    fun getType(@StyleableRes index: Int): Int

    /**
     * @see android.content.res.TypedArray.hasValue
     */
    fun hasValue(@StyleableRes index: Int): Boolean

    /**
     * @see android.content.res.TypedArray.hasValueOrEmpty
     */
    fun hasValueOrEmpty(@StyleableRes index: Int): Boolean

    /**
     * @see android.content.res.TypedArray.peekValue
     */
    fun peekValue(@StyleableRes index: Int): TypedValue

    /**
     * @see android.content.res.TypedArray.getPositionDescription
     */
    fun getPositionDescription(): String

    /**
     * @see android.content.res.TypedArray.recycle
     */
    fun recycle()
}