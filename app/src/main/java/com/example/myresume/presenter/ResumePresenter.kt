package com.example.myresume.presenter

import com.example.myresume.domain.errors.ResumeErrors
import com.example.myresume.domain.interactors.GetResumeInteractor
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.view.CommonView
import io.reactivex.disposables.CompositeDisposable

class ResumePresenter(
    private val commonView: CommonView,
    private val resourceManager: StringsResolver,
    private val resumeUseCase: GetResumeInteractor,
    private val mainView: MainActivityContract.View
): MainActivityContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun initView() {
        mainView.initView()
    }

    override fun downloadResume() {
        disposables.add(resumeUseCase.execute()
            .doOnSubscribe { commonView.showProgressBar() }
            .subscribe ({ resumeData ->
                commonView.hideProgressBar()
                resumeData.basics?.let {
                    mainView.renderBasicInformation(it)
                } ?: run {
                    commonView.showError(resourceManager.getUnknownExceptionString())
                }
                resumeData.skills?.let {
                    mainView.renderSkillsInformation(it)
                } ?: run {
                    commonView.showError(resourceManager.getUnknownExceptionString())
                }
                resumeData.pastJob?.let {
                    mainView.renderWorksInformation(it)
                } ?: run {
                    commonView.showError(resourceManager.getUnknownExceptionString())
                }
            }, {
                commonView.hideProgressBar()
                if (it is ResumeErrors.TimeoutException) {
                    commonView.showError(resourceManager.getTimeOutExceededString())
                } else {
                    commonView.showError(resourceManager.getUnknownExceptionString())
                }
            }))
    }

    override fun disposeSubscriptions() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}