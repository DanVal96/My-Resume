package com.example.data.services

import com.example.data.remote.ResumeResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ResumeApiServices {

    @GET("5ce96fb33300009627525d69")
    fun getResumeInformation(): Single<ResumeResponse>

    companion object {
        const val BASE_URL =  "http://www.mocky.io/v2/" //Check the new base
    }
}