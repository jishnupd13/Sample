package com.stark.storeapp.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class HorizontalItemDecorator(private val startEndSpace: Int,private val betweenSpace:Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        if (parent.getChildAdapterPosition(view) == 0  ) {
            outRect.left = startEndSpace.px
            outRect.right = betweenSpace.px
            outRect.top = 8.px
            outRect.bottom = 8.px
        }else if(parent.getChildAdapterPosition(view) == (parent.adapter?.itemCount?:0)-1){
            outRect.right = startEndSpace.px
            outRect.top = 8.px
            outRect.bottom = 8.px
        }else{
            outRect.right = betweenSpace.px
            outRect.top = 8.px
            outRect.bottom = 8.px
        }
    }
}