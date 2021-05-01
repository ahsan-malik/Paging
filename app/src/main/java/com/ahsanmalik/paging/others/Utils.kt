package com.ahsanmalik.paging.others

import android.view.View
import android.widget.ImageView
import com.ahsanmalik.paging.R
import com.bumptech.glide.Glide

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .error(R.drawable.ic_twotone_error_24)
        .placeholder(R.drawable.ic_twotone_image_24)
        .into(this)
}