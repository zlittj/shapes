package com.shapes.jzachlittle.shapes

import android.content.ClipData
import android.util.Log
import android.view.View
import java.util.*

class MainActivityPresenter(var shapesContract: ShapesContract.View) : ShapesContract.Presenter {

    override fun onShapeDrag(view: View) {
        //shapesContract.updateView()
    }

    fun setupShape() {
        val shapeInt = (0..1).random()
        val holeMarginBottom = (0..400).random()
        val holeMargiStart = (0..1000).random()
        val imageMarginBottom = (0..400).random()
        val imageMarginStart = (0..1000).random()
        val shapeDrawables = getTheGood(shapeInt)
        val randomShape = RandomShape(shapeDrawables.image, shapeDrawables.hole, imageMarginBottom, imageMarginStart,
                holeMarginBottom, holeMargiStart)
    }

    fun getTheGood(positon: Int): MainActivityPresenter.shapeDrawables {
        if (positon == 0) {
            return shapeDrawables.SQUARE
        } else if (positon ==1) {
            return shapeDrawables.CIRCLE
        }
        return shapeDrawables.SQUARE
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive -start) + start

    enum class shapeDrawables(val image: Int, val hole: Int) {
        SQUARE(R.drawable.square, R.drawable.square_hole),
        CIRCLE(R.drawable.circle, R.drawable.circle_hole)
    }
}