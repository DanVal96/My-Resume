package com.example.myresume.presenter

import com.example.myresume.domain.errors.ResumeErrors
import com.example.myresume.domain.interactors.GetResumeInteractor
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.view.GenericMethodsView
import io.reactivex.disposables.CompositeDisposable

class ResumePresenter(
    private val genericMethodsView: GenericMethodsView,
    private val resourceManager: StringsResolver,
    private val resumeUseCase: GetResumeInteractor,
    private val resumeView: ResumeActivityContract.View
): ResumeActivityContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun initView() {
        resumeView.initView()
    }

    override fun downloadResume() {
        disposables.add(resumeUseCase.execute()
            .doOnSubscribe { genericMethodsView.showProgressBar() }
            .subscribe ({ resumeData ->
                genericMethodsView.hideProgressBar()
                resumeData.basics?.let {
                    resumeView.renderBasicInformation(it)
                } ?: run {
                    genericMethodsView.showError(resourceManager.getUnknownExceptionString())
                }
                resumeData.skills?.let {
                    resumeView.renderSkillsInformation(it)
                } ?: run {
                    genericMethodsView.showError(resourceManager.getUnknownExceptionString())
                }
                resumeData.pastJob?.let {
                    resumeView.renderWorksInformation(it)
                } ?: run {
                    genericMethodsView.showError(resourceManager.getUnknownExceptionString())
                }
            }, {
                genericMethodsView.hideProgressBar()
                if (it is ResumeErrors.TimeoutException) {
                    genericMethodsView.showError(resourceManager.getTimeOutExceededString())
                } else {
                    genericMethodsView.showError(resourceManager.getUnknownExceptionString())
                }
            }))
    }

    override fun disposeSubscriptions() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}