package com.example.data.executor

import com.example.myresume.domain.executor.UiThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UiExecutor: UiThreadExecutor {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}