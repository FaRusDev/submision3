package com.example.f.submision3.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View

@BindingAdapter("tes:visibility")
fun mutableVisibility(v: View, visible:Boolean){
    v.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("tes:rvAdapter")
fun mutableAdapter(rv: RecyclerView,adapter: RecyclerView.Adapter<*>){
    rv.adapter = adapter
}