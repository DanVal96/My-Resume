package com.example.data.models

import com.google.gson.annotations.SerializedName

data class PastJob(
    @SerializedName("company")
    val company: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("urlImage")
    val urlImage: String?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("summary")
    val summary: String?
)