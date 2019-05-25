package com.example.data.executor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/example/data/executor/JobExecutor;", "Lcom/example/myresume/domain/executor/BackgroundExecutor;", "()V", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadPoolExecutor$delegate", "Lkotlin/Lazy;", "execute", "", "runnable", "Ljava/lang/Runnable;", "Companion", "JobThreadFactory", "data_debug"})
public final class JobExecutor implements com.example.myresume.domain.executor.BackgroundExecutor {
    private final kotlin.Lazy threadPoolExecutor$delegate = null;
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAXIMUM_POOL_SIZE = 5;
    private static final long KEEP_ALIVE_TIME = 10L;
    private static final java.lang.String BASE_NAME_THREAD = "android_";
    public static final com.example.data.executor.JobExecutor.Companion Companion = null;
    
    private final java.util.concurrent.ThreadPoolExecutor getThreadPoolExecutor() {
        return null;
    }
    
    @java.lang.Override()
    public void execute(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
    }
    
    public JobExecutor() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/data/executor/JobExecutor$JobThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "counter", "", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "data_debug"})
    static final class JobThreadFactory implements java.util.concurrent.ThreadFactory {
        private int counter;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.Thread newThread(@org.jetbrains.annotations.NotNull()
        java.lang.Runnable runnable) {
            return null;
        }
        
        public JobThreadFactory() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/data/executor/JobExecutor$Companion;", "", "()V", "BASE_NAME_THREAD", "", "CORE_POOL_SIZE", "", "KEEP_ALIVE_TIME", "", "MAXIMUM_POOL_SIZE", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}