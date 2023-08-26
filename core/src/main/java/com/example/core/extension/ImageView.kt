package com.example.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadImage(src: String) = Glide
    .with(this)
    .load(src)
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .into(this)
