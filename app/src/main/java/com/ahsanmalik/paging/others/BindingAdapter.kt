package com.ahsanmalik.paging.others

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("loadImage")
fun setImage(imageView: ImageView, url: String) {
    imageView.loadImage(url)
}
