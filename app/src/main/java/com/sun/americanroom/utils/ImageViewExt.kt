package com.sun.americanroom.utils

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImage(urlImage: String) {
    Glide.with(this)
        .load(urlImage)
        .into(this)
}
