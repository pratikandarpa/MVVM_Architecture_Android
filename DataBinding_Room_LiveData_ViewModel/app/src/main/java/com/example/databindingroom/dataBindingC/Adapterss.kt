package com.example.databindingroom.dataBindingC

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFNet")
fun ImageView.imageFromNet(url: String) {
    Glide.with(this.context).load(url).into(this)
}