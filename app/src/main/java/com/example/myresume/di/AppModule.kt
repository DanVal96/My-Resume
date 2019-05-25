package com.example.myresume.di

import android.content.Context
import android.content.res.Resources
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.domain.repository.ResumeRepository
import com.example.myresume.resolver.ResumeStringsResolver
import com.example.myresume.services.ImageDownloader
import com.example.myresume.services.PicassImageDownloader
import com.example.data.local.CacheDataSource
import com.example.data.repository.ResumeInformationDataRepository
import com.example.data.services.ResumeApiServices
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesAppContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun providesResumeRepository(resumeServices: ResumeApiServices,
                                 cacheDataSource: CacheDataSource): ResumeRepository {
        return ResumeInformationDataRepository(resumeServices, cacheDataSource)
    }

    @Singleton
    @Provides
    fun providesImageDownloader(): ImageDownloader {
        return PicassImageDownloader()
    }

    @Provides
    @Singleton
    fun providesResources(context: Context): Resources {
        return context.resources
    }

    @Provides
    @Singleton
    fun providesStringResolver(resources: Resources): StringsResolver {
        return ResumeStringsResolver(resources)
    }


}