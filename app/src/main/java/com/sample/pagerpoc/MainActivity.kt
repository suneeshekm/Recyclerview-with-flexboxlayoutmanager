package com.sample.pagerpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.sample.pagerpoc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        title = "Horizontal recycler view"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val flexBoxLayoutManager = FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.NOWRAP)
        with(recyclerView) {
            layoutManager = flexBoxLayoutManager
            adapter = RecyclerViewAdapter()
            setHasFixedSize(false)
        }
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(recyclerView)

    }
}