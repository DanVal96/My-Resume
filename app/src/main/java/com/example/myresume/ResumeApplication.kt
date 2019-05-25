package com.example.myresume

import android.app.Application
import com.example.myresume.di.AppComponent
import com.example.myresume.di.AppModule
import com.example.myresume.di.DaggerAppComponent
import com.example.data.di.DataModule
import com.example.data.di.ApiModule
import com.example.data.services.ResumeApiServices.Companion.BASE_URL
import com.facebook.stetho.Stetho
import io.realm.Realm

class ResumeApplication: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .apiModule(ApiModule(BASE_URL))
            .build()
    }

    internal fun getAppComponent(): AppComponent {
        return appComponent
    }
}