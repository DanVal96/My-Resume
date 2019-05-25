package com.example.myresume

import com.example.myresume.view.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [MockAppModule::class, MockThreadModule::class])
interface MockAppComponent {
    fun inject(mainActivity: MainActivity)
}