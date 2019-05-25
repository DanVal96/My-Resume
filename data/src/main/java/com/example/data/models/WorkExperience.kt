package com.example.data.models

import com.google.gson.annotations.SerializedName

data class WorkExperience(
    @SerializedName("company")
    val company: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("urlImage")
    val urlImage: String?,
    @SerializedName("periodStart")
    val periodStart: String?,
    @SerializedName("periodEnd")
    val periodEnd: String?,
    @SerializedName("summary")
    val summary: String?
)