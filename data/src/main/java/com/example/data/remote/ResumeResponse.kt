package com.example.data.remote

import com.example.data.models.Basics
import com.example.data.models.Abilities
import com.example.data.models.PastJob
import com.google.gson.annotations.SerializedName

data class ResumeResponse(
    @SerializedName("basics")
    val basics: Basics?,
    @SerializedName("pastJob")
    val pastJob: List<PastJob>?,
    @SerializedName("abilities")
    val abilities: List<Abilities>?
)