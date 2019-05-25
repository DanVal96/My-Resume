package com.example.data.local

import com.example.myresume.domain.models.ResumeData
import com.example.data.remote.ResumeResponse
import io.reactivex.Single

interface CacheDataSource {

    fun storeReceivedData(resumeResponse: ResumeResponse)
    fun getCacheResumeInformation(): Single<ResumeData>
}