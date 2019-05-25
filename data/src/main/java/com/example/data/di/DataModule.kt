package com.example.data.di

import com.example.data.local.CacheDataSource
import com.example.data.local.CacheDatabaseProvider
import com.example.data.local.RealmCacheDataSource
import com.example.data.local.RealmProviderCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

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