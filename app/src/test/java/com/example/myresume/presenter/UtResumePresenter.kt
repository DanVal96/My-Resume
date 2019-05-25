package com.example.myresume.presenter

import com.example.myresume.domain.errors.ResumeErrors
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.domain.models.*
import com.example.myresume.domain.interactors.GetResumeInteractor
import com.example.myresume.view.GenericMethodsView
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class UtResumePresenter {

    @Mock
    private lateinit var resumeActivityView: ResumeActivityContract.View

    @Mock
    private lateinit var genericMethodsView: GenericMethodsView
    @Mock
    private lateinit var stringsResolver: StringsResolver
    @Mock
    private lateinit var resumeUseCase: GetResumeInteractor

    private lateinit var resumeActivityPresenter: ResumeActivityContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resumeActivityPresenter = ResumePresenter(genericMethodsView, stringsResolver, resumeUseCase, resumeActivityView)
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn("")
    }

    @Test
    fun testInitView() {
        resumeActivityPresenter.initView()
        verify(resumeActivityView).initView()
    }

    @Test
    fun testGetResumeInformationWithallData() {
        val genericErrorMessage = "genericMessage"
        val receivedSkillsData = createSkillDataList()
        val receivedBasicsData = createBasicsData()
        val receivedWorkData = createWorkDataList()
        val resumeData = ResumeData(receivedBasicsData, receivedWorkData, receivedSkillsData)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn(genericErrorMessage)

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(genericMethodsView, times(0)).showError(genericErrorMessage)
        verify(resumeActivityView).renderBasicInformation(receivedBasicsData)
        verify(resumeActivityView).renderSkillsInformation(receivedSkillsData)
        verify(resumeActivityView).renderWorksInformation(receivedWorkData)
    }

    @Test
    fun testGetResumeInformationSuccessfulWithNoData() {
        val resumeData = ResumeData()
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(genericMethodsView, atLeastOnce()).showError("")
        verify(resumeActivityView, times(0)).renderBasicInformation(BasicsData())
        verify(resumeActivityView, times(0)).renderSkillsInformation(emptyList())
        verify(resumeActivityView, times(0)).renderWorksInformation(emptyList())
    }

    @Test
    fun testGetResumeInformationWithOnlySkills() {
        val receivedSkillsData = createSkillDataList()
        val resumeData = ResumeData(null, null, receivedSkillsData)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView, atLeastOnce()).showError("")
        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(resumeActivityView, times(0)).renderBasicInformation(BasicsData())
        verify(resumeActivityView).renderSkillsInformation(receivedSkillsData)
        verify(resumeActivityView, times(0)).renderWorksInformation(emptyList())
    }

    @Test
    fun testGetResumeInformationWithOnlyBasics() {
        val receivedBasicsData = createBasicsData()
        val resumeData = ResumeData(receivedBasicsData, null, null)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView, atLeastOnce()).showError("")
        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(resumeActivityView).renderBasicInformation(receivedBasicsData)
        verify(resumeActivityView, times(0)).renderSkillsInformation(emptyList())
        verify(resumeActivityView, times(0)).renderWorksInformation(emptyList())
    }

    @Test
    fun testGetResumeInformationWithOnlyWorks() {
        val receivedWorks = createWorkDataList()
        val resumeData = ResumeData(null, receivedWorks, null)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView, atLeastOnce()).showError("")
        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(resumeActivityView, times(0)).renderBasicInformation(BasicsData())
        verify(resumeActivityView, times(0)).renderSkillsInformation(emptyList())
        verify(resumeActivityView).renderWorksInformation(receivedWorks)
    }

    @Test
    fun testGetResumeInformationWithTimeoutException() {
        val timeoutErrorMessage = "Timeout Error"
        whenever(resumeUseCase.execute()).thenReturn(Single.error(ResumeErrors.TimeoutException()))
        whenever(stringsResolver.getTimeOutExceededString()).thenReturn(timeoutErrorMessage)

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(genericMethodsView).showError(timeoutErrorMessage)
    }

    @Test
    fun testGetResumeInformationWithGenericException() {
        val genericErrorMessage = "genericMessage"
        whenever(resumeUseCase.execute()).thenReturn(Single.error(ResumeErrors.GenericError()))
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn(genericErrorMessage)

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(genericMethodsView).showError(genericErrorMessage)
    }

    @Test
    fun testGetResumeInformationWithAnyOtherException() {
        val genericErrorMessage = "genericMessage"
        whenever(resumeUseCase.execute()).thenReturn(Single.error(IllegalStateException()))
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn(genericErrorMessage)

        resumeActivityPresenter.downloadResume()

        verify(genericMethodsView).showProgressBar()
        verify(genericMethodsView).hideProgressBar()
        verify(genericMethodsView).showError(genericErrorMessage)
    }

    private fun createSkillDataList(): List<SkillsData> {
        return listOf(SkillsData(SKILL_NAME, SKILL_LEVEL, SKILL_KEYWORDS, SKILL_URL_IMAGE))
    }

    private fun createWorkDataList(): List<PastJobData> {
        return listOf(
            PastJobData(WORK_COMPANY,
                WORK_POSITION,
                WORK_URL_IMAGE,
                WORK_PERIOD_START,
                WORK_PERIOD_END,
                WORK_SUMMARY)
        )
    }

    private fun createBasicsData(): BasicsData {
        return BasicsData(BASICS_NAME,
            BASICS_TITLE,
            BASICS_URL_IMAGE,
            BASICS_EMAIL,
            BASICS_PROFILE)
    }

    companion object {
        const val WORK_COMPANY = "workCompany"
        const val WORK_POSITION = "workPosition"
        const val WORK_URL_IMAGE = "workUrlImage"
        const val WORK_PERIOD_START = "workPeriodStart"
        const val WORK_PERIOD_END = "workPeriodEnd"
        const val WORK_SUMMARY = "workSummary"
        const val SKILL_NAME = "skillName"
        const val SKILL_LEVEL = "skillLevel"
        val SKILL_KEYWORDS = listOf("android", "kotlin")
        const val SKILL_URL_IMAGE = "skillUrlImage"
        const val BASICS_NAME = "name"
        const val BASICS_TITLE = "title"
        const val BASICS_URL_IMAGE = "urlImage"
        const val BASICS_EMAIL = "email"
        const val BASICS_PROFILE = "profile"
    }
}