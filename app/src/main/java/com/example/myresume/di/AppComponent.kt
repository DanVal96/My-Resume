package com.example.myresume.di

import com.example.myresume.view.ResumeActivity
import com.example.data.di.DataModule
import com.example.data.di.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ApiModule::class, ThreadsModule::class])
interface AppComponent {
    fun inject(resumeActivity: ResumeActivity)
}