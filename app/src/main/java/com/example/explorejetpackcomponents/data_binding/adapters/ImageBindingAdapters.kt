package com.example.explorejetpackcomponents.data_binding.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.explorejetpackcomponents.R

@BindingAdapter("imageUrl")
fun setImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.placeholder)
        .fitCenter()
        .into(imageView)
}