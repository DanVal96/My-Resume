package com.example.data.services

import com.example.data.remote.ResumeResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ResumeApiServices {

    @GET("5ce9a0e93300002737525dc2")
    fun getResumeInformation(): Single<ResumeResponse>

    companion object {
        const val BASE_URL =  "http://www.mocky.io/v2/"
    }
}