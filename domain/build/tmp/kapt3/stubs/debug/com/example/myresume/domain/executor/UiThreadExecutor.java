package com.example.myresume.domain.executor;

import java.lang.System;

/**
 * * Thread abstraction created to change the execution context from any thread to any other thread.
 * * Useful to encapsulate a UI Thread for example, since some job will be done in background, an
 * * implementation of this interface will change context and update the UI.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/myresume/domain/executor/UiThreadExecutor;", "", "getScheduler", "Lio/reactivex/Scheduler;", "domain_debug"})
public abstract interface UiThreadExecutor {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Scheduler getScheduler();
}