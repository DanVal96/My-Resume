package com.example.data.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/data/local/RealmCacheDataSource;", "Lcom/example/data/local/CacheDataSource;", "realmProviderCache", "Lcom/example/data/local/CacheDatabaseProvider;", "(Lcom/example/data/local/CacheDatabaseProvider;)V", "getCacheResumeInformation", "Lio/reactivex/Single;", "Lcom/example/myresume/domain/models/ResumeData;", "storeReceivedData", "", "resumeResponse", "Lcom/example/data/remote/ResumeResponse;", "data_debug"})
public final class RealmCacheDataSource implements com.example.data.local.CacheDataSource {
    private final com.example.data.local.CacheDatabaseProvider realmProviderCache = null;
    
    @java.lang.Override()
    public void storeReceivedData(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ResumeResponse resumeResponse) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.example.myresume.domain.models.ResumeData> getCacheResumeInformation() {
        return null;
    }
    
    public RealmCacheDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.local.CacheDatabaseProvider realmProviderCache) {
        super();
    }
}