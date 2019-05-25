package com.example.myresume

import com.example.myresume.di.AppComponent

class MockMyResumeApp: ResumeApplication() {

    override fun createComponent(): AppComponent {
        return DaggerMockAppComponent.builder()
            .mockAppModule(MockAppModule())
            .mockThreadModule(MockThreadModule())
            .build() as AppComponent
    }
}