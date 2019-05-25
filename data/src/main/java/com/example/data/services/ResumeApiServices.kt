package com.example.data.services

import com.example.data.remote.ResumeResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ResumeApiServices {

    @GET("resume-app")
    fun getResumeInformation(): Single<ResumeResponse>

    companion object {
        const val BASE_URL =  "http://demo6959920.mockable.io/" //Check the new base
    }
}