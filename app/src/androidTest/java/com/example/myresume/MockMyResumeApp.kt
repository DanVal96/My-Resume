package com.example.myresume

import com.example.myresume.di.AppComponent
import com.example.myresume.view.MainActivity

class MockMyResumeApp: ResumeApplication() {

    override fun createComponent(): AppComponent {
        return DaggerMock
    }
}