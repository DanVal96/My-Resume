package com.example.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/example/data/repository/ResumeInformationDataRepository;", "Lcom/example/myresume/domain/repository/ResumeRepository;", "resumeServices", "Lcom/example/data/services/ResumeApiServices;", "cacheDataSource", "Lcom/example/data/local/CacheDataSource;", "(Lcom/example/data/services/ResumeApiServices;Lcom/example/data/local/CacheDataSource;)V", "getCacheDataSource", "()Lcom/example/data/local/CacheDataSource;", "getResumeServices", "()Lcom/example/data/services/ResumeApiServices;", "getCachedData", "Lio/reactivex/Single;", "Lcom/example/myresume/domain/models/ResumeData;", "getResumeData", "saveDataInCache", "", "resumeResponse", "Lcom/example/data/remote/ResumeResponse;", "data_debug"})
@javax.inject.Singleton()
public final class ResumeInformationDataRepository implements com.example.myresume.domain.repository.ResumeRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.data.services.ResumeApiServices resumeServices = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.data.local.CacheDataSource cacheDataSource = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.example.myresume.domain.models.ResumeData> getResumeData() {
        return null;
    }
    
    private final io.reactivex.Single<com.example.myresume.domain.models.ResumeData> getCachedData() {
        return null;
    }
    
    private final void saveDataInCache(com.example.data.remote.ResumeResponse resumeResponse) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.services.ResumeApiServices getResumeServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.CacheDataSource getCacheDataSource() {
        return null;
    }
    
    @javax.inject.Inject()
    public ResumeInformationDataRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.services.ResumeApiServices resumeServices, @org.jetbrains.annotations.NotNull()
    com.example.data.local.CacheDataSource cacheDataSource) {
        super();
    }
}