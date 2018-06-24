package com.shapes.jzachlittle.shapes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.shapes.jzachlittle.shapes.databinding.ActivityMainBinding
import android.view.ViewGroup.MarginLayoutParams
import android.databinding.BindingAdapter
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val shape = Shape(getDrawable(R.drawable.square), this.getDrawable(R.drawable.square_hole), 50, 50, 150, 100)
        binding.shape = shape
        binding.executePendingBindings()
    }


}
