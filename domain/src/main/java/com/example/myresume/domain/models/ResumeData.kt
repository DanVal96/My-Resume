package com.example.myresume.domain.models

data class ResumeData(
        val basics: BasicsData? = null,
        val pastJob: List<PastJobData>? = null,
        val skills: List<SkillsData>? = null
)