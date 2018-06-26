package com.shapes.jzachlittle.shapes

import android.databinding.BindingAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


object MarginBindingAdapter {

        @BindingAdapter("android:layout_marginTop")
        @JvmStatic
        fun setTopMargin(view: View, topMargin: Float) {
            val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.setMargins(layoutParams.leftMargin, Math.round(topMargin),
                    layoutParams.rightMargin, layoutParams.bottomMargin)
            view.layoutParams = layoutParams
        }

        @BindingAdapter("android:layout_marginStart")
        @JvmStatic
        fun setStartargin(view: View, startMargin: Float) {
            val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.setMargins(Math.round(startMargin), layoutParams.topMargin,
                    layoutParams.rightMargin, layoutParams.bottomMargin)
            view.layoutParams = layoutParams
        }

}