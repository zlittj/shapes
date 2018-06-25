package com.shapes.jzachlittle.shapes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.shapes.jzachlittle.shapes.databinding.ActivityMainBinding
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout


class MainActivity : AppCompatActivity(), ShapesContract.View, View.OnDragListener, View.OnTouchListener {

    var imageWidth = 0
    var imageHeight = 0
    var holeWidth = 0
    var holeHeight = 0
    var holeX = 0
    var holeY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var mainActivityPresenter = MainActivityPresenter(this)
        var shape = Shape(getDrawable(R.drawable.square), this.getDrawable(R.drawable.square_hole),
                50, 50, 150, 100)
        setParams(shape)
        binding.shape = shape
        binding.presenter = mainActivityPresenter
        findViewById<RelativeLayout>(R.id.backdrop).setOnDragListener(this)
        findViewById<ImageView>(R.id.imageShape).setOnTouchListener(this)
        binding.executePendingBindings()
    }

    override fun updateView() {
        Log.i("TAG", "inMainActivity")
    }

    fun setParams(shape: Shape) {
        imageWidth = shape.image.intrinsicWidth
        imageHeight = shape.image.intrinsicHeight
        holeWidth = shape.hole.intrinsicWidth/2
        holeHeight = shape.hole.intrinsicHeight/2
        holeX = shape.holeLayoutMarginLeft
        holeY = shape.holeLayoutMarginBottom

    }

    override fun onDrag(v: View?, event: DragEvent?): Boolean {
        val view = event!!.localState as View
        Log.i("TAG", "onDragEvent: " + event.action)
        if (event.action == DragEvent.ACTION_DROP) {
            val viewGroup = view.parent as ViewGroup
            viewGroup.removeView(view)
            val relativeLayout = v as RelativeLayout
            view.x = event.x - imageWidth/2
            view.y = event.y - imageHeight/2
            Log.i("TAG", "onDrag holex: " + holeX+ " holey:"+holeY )
            Log.i("TAG", "onDrag holewidth: " + holeWidth+ " holeHeight:"+holeHeight )
            Log.i("TAG", "onDrag x: " + view.x+ " y:"+view.y  )
            relativeLayout.addView(view)
            if (isInBounds(Math.round(view.x), Math.round(view.y))) {
                view.visibility = View.INVISIBLE
            } else {
                view.visibility = View.VISIBLE
            }
        }
        return true
    }

    fun isInBounds(x: Int, y: Int): Boolean {
        if (x<(holeWidth+ holeX) && x> holeX && y<(holeHeight+holeY) && y>holeY) {
        return true
        }
        return false
    }



    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        Log.i("TAG", "onEvent: " + event!!.action)
        if (event!!.actionButton == MotionEvent.ACTION_DOWN) {
            val shadowBuilder = View.DragShadowBuilder(v)
            v!!.visibility = View.INVISIBLE
            v?.startDragAndDrop(null, shadowBuilder, v, 0)
            return true
        } else if (event!!.actionButton == MotionEvent.ACTION_UP) {
            v!!.visibility = View.VISIBLE
            return false
        }
        return false
    }
}
