package com.stark.storeapp.utils.profileoptionsview

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.stark.storeapp.R
import com.stark.storeapp.utils.customtextview.StoreAppCustomTextView

class ProfileOptionsView@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
):FrameLayout(context,attrs) {

    private var icon:AppCompatImageView?=null
    private var optionTextView:StoreAppCustomTextView?=null

    init {
        initializeOptionView(attrs)
    }

    private fun initializeOptionView(attrs: AttributeSet?){
        val data = context.obtainStyledAttributes(attrs, R.styleable.ProfileOptionsView)
        val optionText = data.getText(R.styleable.ProfileOptionsView_optionText)?:""
        val optionImage = data.getDrawable(R.styleable.ProfileOptionsView_optionIcon)
        data.recycle()

        inflate(context,R.layout.layout_profile_options,this)
        icon = findViewById(R.id.imageOption)
        optionTextView = findViewById(R.id.textOption)
        icon?.setImageDrawable(optionImage)
        optionTextView?.text = optionText
        refreshDrawableState()
    }
}