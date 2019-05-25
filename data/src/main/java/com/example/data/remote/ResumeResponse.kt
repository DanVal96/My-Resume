package com.example.data.remote

import com.example.data.models.PersonalInfo
import com.example.data.models.Skills
import com.example.data.models.WorkExperience
import com.google.gson.annotations.SerializedName

data class ResumeResponse(
    @SerializedName("personalInfo")
    val personalInfo: PersonalInfo?,
    @SerializedName("workExperience")
    val workExperience: List<WorkExperience>?,
    @SerializedName("skills")
    val skills: List<Skills>?
)