package com.example.data.di

import com.example.myresume.domain.executor.UiThreadExecutor
import com.example.myresume.domain.executor.BackgroundExecutor
import com.example.data.local.CacheDatabaseProvider
import com.example.data.local.CacheDataSource
import com.example.data.local.RealmProviderCache
import com.example.data.local.RealmCacheDataSource
import com.example.data.executor.JobExecutor
import com.example.data.executor.UiExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

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

    @Provides
    @Singleton
    fun providesDatabaseProvider(): CacheDatabaseProvider {
        return RealmProviderCache()
    }

    @Provides
    @Singleton
    fun providesLocalDataSource(realmProviderCache: CacheDatabaseProvider): CacheDataSource {
        return RealmCacheDataSource(realmProviderCache)
    }
}