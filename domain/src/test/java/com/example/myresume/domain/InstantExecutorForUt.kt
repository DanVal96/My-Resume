package com.example.myresume.domain

import com.example.myresume.domain.executor.BackgroundExecutor

class ImmediateThreadExecutor: BackgroundExecutor {
    override fun execute(runnable: Runnable?) {
        runnable?.run()
    }
}