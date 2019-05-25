package com.example.data.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/data/di/DataModule;", "", "()V", "providesDatabaseProvider", "Lcom/example/data/local/CacheDatabaseProvider;", "providesJobExecutor", "Lcom/example/myresume/domain/executor/BackgroundExecutor;", "providesLocalDataSource", "Lcom/example/data/local/CacheDataSource;", "realmProviderCache", "providesPostExecutionThread", "Lcom/example/myresume/domain/executor/UiThreadExecutor;", "data_debug"})
@dagger.Module()
public final class DataModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.myresume.domain.executor.BackgroundExecutor providesJobExecutor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.myresume.domain.executor.UiThreadExecutor providesPostExecutionThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.data.local.CacheDatabaseProvider providesDatabaseProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.data.local.CacheDataSource providesLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.local.CacheDatabaseProvider realmProviderCache) {
        return null;
    }
    
    public DataModule() {
        super();
    }
}