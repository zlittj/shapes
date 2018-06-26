package com.shapes.jzachlittle.shapes

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.graphics.drawable.Drawable
import android.view.View

data class Shape(var image: Drawable, var hole: Drawable, var imageLayoutMarginTop: Int,
                 var imageLayoutMarginStart: Int, var holeLayoutMarginTop: Int,
                 var holeLayoutMarginStart: Int) : BaseObservable() {
}
