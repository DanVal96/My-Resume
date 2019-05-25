package com.example.myresume.view

interface CommonView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showError(errorMessage: String)
}