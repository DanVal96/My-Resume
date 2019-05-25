package com.example.data.models

import com.google.gson.annotations.SerializedName

data class PersonalInfo(
    @SerializedName("name")
    val name: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("urlImage")
    val urlImage: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("profile")
    val profile: String?
)