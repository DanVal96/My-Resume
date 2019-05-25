package com.example.myresume.domain.interactors;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/example/myresume/domain/interactors/GetResumeInteractor;", "", "resumeRepository", "Lcom/example/myresume/domain/repository/ResumeRepository;", "executionScheduler", "Lcom/example/myresume/domain/executor/BackgroundExecutor;", "uiSchedulerExecutor", "Lcom/example/myresume/domain/executor/UiThreadExecutor;", "(Lcom/example/myresume/domain/repository/ResumeRepository;Lcom/example/myresume/domain/executor/BackgroundExecutor;Lcom/example/myresume/domain/executor/UiThreadExecutor;)V", "getExecutionScheduler", "()Lcom/example/myresume/domain/executor/BackgroundExecutor;", "getResumeRepository", "()Lcom/example/myresume/domain/repository/ResumeRepository;", "getUiSchedulerExecutor", "()Lcom/example/myresume/domain/executor/UiThreadExecutor;", "execute", "Lio/reactivex/Single;", "Lcom/example/myresume/domain/models/ResumeData;", "domain_debug"})
@javax.inject.Singleton()
public final class GetResumeInteractor {
    @org.jetbrains.annotations.NotNull()
    private final com.example.myresume.domain.repository.ResumeRepository resumeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.myresume.domain.executor.BackgroundExecutor executionScheduler = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.myresume.domain.executor.UiThreadExecutor uiSchedulerExecutor = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.example.myresume.domain.models.ResumeData> execute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.myresume.domain.repository.ResumeRepository getResumeRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.myresume.domain.executor.BackgroundExecutor getExecutionScheduler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.myresume.domain.executor.UiThreadExecutor getUiSchedulerExecutor() {
        return null;
    }
    
    @javax.inject.Inject()
    public GetResumeInteractor(@org.jetbrains.annotations.NotNull()
    com.example.myresume.domain.repository.ResumeRepository resumeRepository, @org.jetbrains.annotations.NotNull()
    com.example.myresume.domain.executor.BackgroundExecutor executionScheduler, @org.jetbrains.annotations.NotNull()
    com.example.myresume.domain.executor.UiThreadExecutor uiSchedulerExecutor) {
        super();
    }
}