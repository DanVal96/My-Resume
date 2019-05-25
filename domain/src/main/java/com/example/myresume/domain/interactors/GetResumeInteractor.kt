package com.example.myresume.domain.interactors

import com.example.myresume.domain.executor.UiThreadExecutor
import com.example.myresume.domain.executor.BackgroundExecutor
import com.example.myresume.domain.models.ResumeData
import com.example.myresume.domain.repository.ResumeRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetResumeInteractor @Inject constructor(val resumeRepository: ResumeRepository,
                                              val executionScheduler: BackgroundExecutor,
                                              val uiSchedulerExecutor: UiThreadExecutor) {

    fun execute(): Single<ResumeData> {
        return resumeRepository.getResumeData()
                .subscribeOn(Schedulers.from(executionScheduler))
                .observeOn(uiSchedulerExecutor.getScheduler())
    }
}