package com.example.myresume.services

import android.widget.ImageView

interface ImageDownloader {

    fun loadImage(imageView: ImageView, imageUrl: String?)
}