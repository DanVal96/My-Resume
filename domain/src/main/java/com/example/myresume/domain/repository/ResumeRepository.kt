package com.example.myresume.domain.repository

import com.example.myresume.domain.models.ResumeData
import io.reactivex.Single

interface ResumeRepository {

    fun getResumeData(): Single<ResumeData>
}