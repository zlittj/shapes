package com.shapes.jzachlittle.shapes

import android.view.View

interface ShapesContract {

    interface Presenter {
        fun onHoleClickReset()
    }

    interface View {
        fun updateView(randomShape: RandomShape)
    }
}