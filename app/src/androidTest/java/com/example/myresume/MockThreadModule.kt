package com.example.myresume

import com.example.myresume.domain.executor.BackgroundExecutor
import com.example.myresume.domain.executor.UiThreadExecutor
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class MockThreadModule {

    @Provides
    @Singleton
    fun providesJobExecutor(): BackgroundExecutor {
        return object: BackgroundExecutor {
            override fun execute(command: Runnable?) {
                command?.run()
            }
        }
    }

    @Provides
    @Singleton
    fun providesPostExecutionThread(): UiThreadExecutor {
        return object: UiThreadExecutor {
            override fun getScheduler(): Scheduler {
                return Schedulers.trampoline()
            }
        }
    }
}