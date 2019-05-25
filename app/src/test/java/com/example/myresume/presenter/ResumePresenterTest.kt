package com.example.myresume.presenter

import com.example.myresume.domain.errors.ResumeErrors
import com.example.myresume.domain.resolver.StringsResolver
import com.example.myresume.domain.models.*
import com.example.myresume.domain.interactors.GetResumeInteractor
import com.example.myresume.view.CommonView
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class ResumePresenterTest {

    @Mock
    private lateinit var mainActivityView: MainActivityContract.View

    @Mock
    private lateinit var commonView: CommonView
    @Mock
    private lateinit var stringsResolver: StringsResolver
    @Mock
    private lateinit var resumeUseCase: GetResumeInteractor

    private lateinit var mainActivityPresenter: MainActivityContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivityPresenter = ResumePresenter(commonView, stringsResolver, resumeUseCase, mainActivityView)
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn("")
    }

    @Test
    fun testInitView() {
        mainActivityPresenter.initView()
        verify(mainActivityView).initView()
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

        mainActivityPresenter.downloadResume()

        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(commonView, times(0)).showError(genericErrorMessage)
        verify(mainActivityView).renderBasicInformation(receivedBasicsData)
        verify(mainActivityView).renderSkillsInformation(receivedSkillsData)
        verify(mainActivityView).renderWorksInformation(receivedWorkData)
    }

    @Test
    fun testGetResumeInformationSuccessfulWithNoData() {
        val resumeData = ResumeData()
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        mainActivityPresenter.downloadResume()

        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(commonView, atLeastOnce()).showError("")
        verify(mainActivityView, times(0)).renderBasicInformation(BasicsData())
        verify(mainActivityView, times(0)).renderSkillsInformation(emptyList())
        verify(mainActivityView, times(0)).renderWorksInformation(emptyList())
    }

    @Test
    fun testGetResumeInformationWithOnlySkills() {
        val receivedSkillsData = createSkillDataList()
        val resumeData = ResumeData(null, null, receivedSkillsData)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        mainActivityPresenter.downloadResume()

        verify(commonView, atLeastOnce()).showError("")
        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(mainActivityView, times(0)).renderBasicInformation(BasicsData())
        verify(mainActivityView).renderSkillsInformation(receivedSkillsData)
        verify(mainActivityView, times(0)).renderWorksInformation(emptyList())
    }

    @Test
    fun testGetResumeInformationWithOnlyBasics() {
        val receivedBasicsData = createBasicsData()
        val resumeData = ResumeData(receivedBasicsData, null, null)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        mainActivityPresenter.downloadResume()

        verify(commonView, atLeastOnce()).showError("")
        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(mainActivityView).renderBasicInformation(receivedBasicsData)
        verify(mainActivityView, times(0)).renderSkillsInformation(emptyList())
        verify(mainActivityView, times(0)).renderWorksInformation(emptyList())
    }

    @Test
    fun testGetResumeInformationWithOnlyWorks() {
        val receivedWorks = createWorkDataList()
        val resumeData = ResumeData(null, receivedWorks, null)
        whenever(resumeUseCase.execute()).thenReturn(Single.just(resumeData))

        mainActivityPresenter.downloadResume()

        verify(commonView, atLeastOnce()).showError("")
        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(mainActivityView, times(0)).renderBasicInformation(BasicsData())
        verify(mainActivityView, times(0)).renderSkillsInformation(emptyList())
        verify(mainActivityView).renderWorksInformation(receivedWorks)
    }

    @Test
    fun testGetResumeInformationWithTimeoutException() {
        val timeoutErrorMessage = "Timeout Error"
        whenever(resumeUseCase.execute()).thenReturn(Single.error(ResumeErrors.TimeoutException()))
        whenever(stringsResolver.getTimeOutExceededString()).thenReturn(timeoutErrorMessage)

        mainActivityPresenter.downloadResume()

        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(commonView).showError(timeoutErrorMessage)
    }

    @Test
    fun testGetResumeInformationWithGenericException() {
        val genericErrorMessage = "genericMessage"
        whenever(resumeUseCase.execute()).thenReturn(Single.error(ResumeErrors.GenericError()))
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn(genericErrorMessage)

        mainActivityPresenter.downloadResume()

        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(commonView).showError(genericErrorMessage)
    }

    @Test
    fun testGetResumeInformationWithAnyOtherException() {
        val genericErrorMessage = "genericMessage"
        whenever(resumeUseCase.execute()).thenReturn(Single.error(IllegalStateException()))
        whenever(stringsResolver.getUnknownExceptionString()).thenReturn(genericErrorMessage)

        mainActivityPresenter.downloadResume()

        verify(commonView).showProgressBar()
        verify(commonView).hideProgressBar()
        verify(commonView).showError(genericErrorMessage)
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