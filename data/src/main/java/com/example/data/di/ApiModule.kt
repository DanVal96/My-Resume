package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.services.ResumeApiServices
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule(val baseUrl: String) {

    @Provides
    @Singleton
    fun providesRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesResumeApiService(retrofit: Retrofit): ResumeApiServices {
        return retrofit.create(ResumeApiServices::class.java)
    }


    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        builder.retryOnConnectionFailure(false)
        builder.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.interceptors().add(httpLoggingInterceptor)
        return  builder.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson,
                         okHttpClient: OkHttpClient,
                         rx2AdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rx2AdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    companion object {
        const val TIME_OUT = 45 // seconds
    }
}