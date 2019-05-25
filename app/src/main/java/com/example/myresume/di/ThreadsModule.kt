package com.example.myresume.di

import com.example.data.executor.JobExecutor
import com.example.data.executor.UiExecutor
import com.example.myresume.domain.executor.BackgroundExecutor
import com.example.myresume.domain.executor.UiThreadExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ThreadsModule {

    @Provides
    @Singleton
    fun providesJobExecutor(): BackgroundExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    fun providesPostExecutionThread(): UiThreadExecutor {
        return UiExecutor()
    }
}