package com.shapes.jzachlittle.shapes

import android.content.ClipData
import android.util.Log
import android.view.View
import java.util.*

class MainActivityPresenter(var shapesContract: ShapesContract.View) : ShapesContract.Presenter {

    override fun onShapeDrag(view: View) {
        shapesContract.updateView()
    }

    fun setupShape() {
        val shapeInt = (0..3).random()
        val holeMarginTop = (0..400).random()
        val holeMargiStart = (0..1000).random()
        val imageMarginBottom = (0..400).random()
        val imageMarginStart = (0..1000).random()
        //val shape = Shape()
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive -start) + start

    enum class shapeDrawables(val image: Int, val hole: Int) {
        SQUARE(R.drawable.square, R.drawable.square_hole)
    }
}