package com.example.myresume

import com.example.myresume.di.AppComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [MockAppModule::class, MockThreadModule::class])
interface MockAppComponent: AppComponent {
    fun inject(mainActivity: UtResumeActivity)
}