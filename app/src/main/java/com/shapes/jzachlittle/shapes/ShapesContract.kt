package com.shapes.jzachlittle.shapes

import android.view.View

interface ShapesContract {

    interface Presenter {
        fun onShapeDrag(view: android.view.View)
    }

    interface View {
        fun updateView(randomShape: RandomShape)
    }
}