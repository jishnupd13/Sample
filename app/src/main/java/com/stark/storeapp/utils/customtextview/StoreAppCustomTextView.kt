package com.stark.storeapp.utils.customtextview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.stark.storeapp.R


class StoreAppCustomTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    //Default it will set to regular
    private var fontStyleValue = 0

    init {
        initializeCustomTextView(attrs)
    }

    private fun initializeCustomTextView(attrs: AttributeSet?){
        val data = context.obtainStyledAttributes(attrs, R.styleable.StoreAppCustomTextView)
        fontStyleValue = data.getInt(R.styleable.StoreAppCustomTextView_fontType,0)
        when(fontStyleValue){
            1-> setFontOpenSansRegular()
            2-> setFontOpenSansLight()
            3->setFontOpenSansBold()
            4->setFontOpenSansSemiBold()
        }
        data.recycle()
        refreshDrawableState()
    }

    private fun setFontOpenSansRegular(){
        val typeface = ResourcesCompat.getFont(context, R.font.open_sans_regular)
        this.typeface = typeface
    }

    private fun setFontOpenSansLight(){
        val typeface = ResourcesCompat.getFont(context, R.font.open_sans_light)
        this.typeface = typeface
    }

    private fun setFontOpenSansBold(){
        val typeface = ResourcesCompat.getFont(context, R.font.open_sans_bold)
        this.typeface = typeface
    }

    private fun setFontOpenSansSemiBold(){
        val typeface = ResourcesCompat.getFont(context, R.font.open_sans_semibold)
        this.typeface = typeface
    }
}