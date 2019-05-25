package com.example.data.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/data/local/CacheDataSource;", "", "getCacheResumeInformation", "Lio/reactivex/Single;", "Lcom/example/myresume/domain/models/ResumeData;", "storeReceivedData", "", "resumeResponse", "Lcom/example/data/remote/ResumeResponse;", "data_debug"})
public abstract interface CacheDataSource {
    
    public abstract void storeReceivedData(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ResumeResponse resumeResponse);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.example.myresume.domain.models.ResumeData> getCacheResumeInformation();
}