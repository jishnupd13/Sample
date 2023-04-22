package com.stark.storeapp.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.stark.storeapp.R
import de.hdodenhof.circleimageview.CircleImageView

fun MotionLayout.animationCompletionObserveListener(observer:()->Unit){
    this.setTransitionListener(object :MotionLayout.TransitionListener{
        override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {}

        override fun onTransitionChange(
            motionLayout: MotionLayout?,
            startId: Int,
            endId: Int,
            progress: Float
        ) {}

        override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
            observer.invoke()
        }

        override fun onTransitionTrigger(
            motionLayout: MotionLayout?,
            triggerId: Int,
            positive: Boolean,
            progress: Float
        ) {}

    })
}

fun ViewPager2.currentPageListener(observer: (position:Int) -> Unit){
    this.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            observer.invoke(position)
        }
    })


}

fun AppCompatImageView.loadImage(url:String){
    Glide
        .with(this.context)
        .load(url)
        .error(R.drawable.placeholder)
        .placeholder(R.drawable.placeholder)
        .into(this)
}

fun AppCompatImageView.loadImageDrawable(drawable:Drawable){
    Glide
        .with(this.context)
        .load(drawable)
        .error(R.drawable.placeholder)
        .placeholder(R.drawable.placeholder)
        .into(this)
}

fun CircleImageView.loadImage(url:String){
    Glide
        .with(this.context)
        .load(url)
        .error(R.drawable.placeholder)
        .placeholder(R.drawable.placeholder)
        .into(this)
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.onClick(onClick:()->Unit){
    this.setOnClickListener {
        onClick.invoke()
    }
}

fun AppCompatActivity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}


fun Fragment.hideKeyboard() {
    activity?.currentFocus?.let { activity?.hideKeyboard(it) }
    activity?.currentFocus?.clearFocus()
}
