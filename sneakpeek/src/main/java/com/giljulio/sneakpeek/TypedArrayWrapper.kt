package com.giljulio.sneakpeek

import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.TypedValue

open class TypedArrayWrapper(private val base: TypedArray): SneakPeekTypedArray {

    override fun length(): Int {
        return base.length()
    }

    override fun getIndexCount(): Int {
        return base.indexCount
    }

    override fun getIndex(at: Int): Int {
        return base.getIndex(at)
    }

    override fun getResources(): Resources {
        return base.resources
    }

    override fun getText(index: Int): CharSequence {
        return base.getText(index)
    }

    override fun getString(index: Int): String? {
        return base.getString(index)
    }

    override fun getNonResourceString(index: Int): String {
        return base.getNonResourceString(index)
    }

    override fun getBoolean(index: Int, defValue: Boolean): Boolean {
        return base.getBoolean(index, defValue)
    }

    override fun getInt(index: Int, defValue: Int): Int {
        return base.getInt(index, defValue)
    }

    override fun getFloat(index: Int, defValue: Float): Float {
        return base.getFloat(index, defValue)
    }

    override fun getColor(index: Int, defValue: Int): Int {
        return base.getColor(index, defValue)
    }

    override fun getColorStateList(index: Int): ColorStateList? {
        return base.getColorStateList(index)
    }

    override fun getInteger(index: Int, defValue: Int): Int {
        return base.getInteger(index, defValue)
    }

    override fun getDimension(index: Int, defValue: Float): Float {
        return base.getDimension(index, defValue)
    }

    override fun getDimensionPixelOffset(index: Int, defValue: Int): Int {
        return base.getDimensionPixelOffset(index, defValue)
    }

    override fun getDimensionPixelSize(index: Int, defValue: Int): Int {
        return base.getDimensionPixelSize(index, defValue)
    }

    override fun getLayoutDimension(index: Int, name: String): Int {
        return base.getLayoutDimension(index, name)
    }

    override fun getLayoutDimension(index: Int, defValue: Int): Int {
        return base.getLayoutDimension(index, defValue)
    }

    override fun getResourceId(index: Int, defValue: Int): Int {
        return base.getResourceId(index, defValue)
    }

    override fun getDrawable(index: Int): Drawable? {
        return base.getDrawable(index)
    }

    override fun getTextArray(index: Int): Array<CharSequence> {
        return base.getTextArray(index)
    }

    override fun getValue(index: Int, outValue: TypedValue): Boolean {
        return base.getValue(index, outValue)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getType(index: Int): Int {
        return base.getType(index)
    }

    override fun hasValue(index: Int): Boolean {
        return base.hasValue(index)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun hasValueOrEmpty(index: Int): Boolean {
        return base.hasValueOrEmpty(index)
    }

    override fun peekValue(index: Int): TypedValue {
        return base.peekValue(index)
    }

    override fun getPositionDescription(): String {
        return base.positionDescription
    }

    override fun recycle() {
        base.recycle()
    }

}
