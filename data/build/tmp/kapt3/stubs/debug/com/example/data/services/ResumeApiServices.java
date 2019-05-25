package com.example.data.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/example/data/services/ResumeApiServices;", "", "getResumeInformation", "Lio/reactivex/Single;", "Lcom/example/data/remote/ResumeResponse;", "Companion", "data_debug"})
public abstract interface ResumeApiServices {
    public static final com.example.data.services.ResumeApiServices.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "http://demo6959920.mockable.io/";
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "resume-app")
    public abstract io.reactivex.Single<com.example.data.remote.ResumeResponse> getResumeInformation();
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/data/services/ResumeApiServices$Companion;", "", "()V", "BASE_URL", "", "data_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "http://demo6959920.mockable.io/";
        
        private Companion() {
            super();
        }
    }
}