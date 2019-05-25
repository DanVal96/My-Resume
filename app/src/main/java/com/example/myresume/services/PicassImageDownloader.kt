package com.example.myresume.services

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassImageDownloader: ImageDownloader {

    override fun loadImage(imageView: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()){
            Picasso.with(imageView.context).load(imageUrl)
                .into(imageView)
        }
    }
}