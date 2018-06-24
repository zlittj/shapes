package com.shapes.jzachlittle.shapes

import android.arch.lifecycle.ViewModel
import android.graphics.drawable.Drawable
import android.view.View

data class Shape(var image: Drawable, var hole: Drawable, var imageLayoutMarginBottom: Int,
                 var imageLayoutMarginLeft: Int, var holeLayoutMarginLeft: Int,
                 var holeLayoutMarginBottom: Int) : ViewModel() {
}