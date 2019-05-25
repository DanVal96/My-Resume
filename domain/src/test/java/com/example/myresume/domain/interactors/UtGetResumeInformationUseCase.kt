package com.example.myresume.domain.interactors

import com.example.myresume.domain.ImmediateThreadExecutor
import com.example.myresume.domain.errors.ResumeErrors
import com.example.myresume.domain.executor.UiThreadExecutor
import com.example.myresume.domain.models.*
import com.example.myresume.domain.repository.ResumeRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class UtGetResumeInformationUseCase {

    @Mock
    private lateinit var resumeRepository: ResumeRepository
    @Mock
    private lateinit var postExecutorExecutor: UiThreadExecutor

    private lateinit var resumeUseCase: GetResumeInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(postExecutorExecutor.getScheduler()).thenReturn(Schedulers.trampoline())
        resumeUseCase = GetResumeInteractor(resumeRepository, ImmediateThreadExecutor(), postExecutorExecutor)
    }

    @Test
    fun testGetResumeInformationSuccessful() {
        val basicsResponse = BasicsData("name",
            "label",
            "urlImage",
            "email",
            "summary")
        val worksResponse = createWorkList()
        val skillsResponse = createSkillsList()
        val resumeInfo = ResumeData(basicsResponse,
            worksResponse,
            skillsResponse)

        whenever(resumeRepository.getResumeData()).thenReturn(Single.just(resumeInfo))

        val receivedResponse = resumeRepository.getResumeData().test().assertComplete().values()[0]

        val receivedBasics = receivedResponse.basics
        val receivedWork = receivedResponse.pastJob?.get(0)
        val receivedSkill = receivedResponse.skills?.get(0)
        Assert.assertEquals(receivedBasics?.name, basicsResponse.name)
        Assert.assertEquals(receivedBasics?.label, basicsResponse.label)
        Assert.assertEquals(receivedBasics?.picture, basicsResponse.picture)
        Assert.assertEquals(receivedBasics?.email, basicsResponse.email)
        Assert.assertEquals(receivedBasics?.summary, basicsResponse.summary)
        Assert.assertEquals(receivedWork?.company, WORK_COMPANY)
        Assert.assertEquals(receivedWork?.position, WORK_POSITION)
        Assert.assertEquals(receivedWork?.startDate, WORK_START_DATE)
        Assert.assertEquals(receivedWork?.endDate, WORK_END_DATE)
        Assert.assertEquals(receivedWork?.urlImage, WORK_URL_IMAGE)
        Assert.assertEquals(receivedWork?.summary, WORK_SUMMARY)
        Assert.assertEquals(receivedSkill?.name, SKILL_NAME)
        Assert.assertEquals(receivedSkill?.level, SKILL_LEVEL)
        Assert.assertEquals(receivedSkill?.keywords?.size, SKILL_KEYWORDS.size)
    }

    @Test
    fun testGetInformationTimeoutError() {
        whenever(resumeRepository.getResumeData())
            .thenReturn(Single.error(ResumeErrors.GenericError()))

        resumeRepository.getResumeData()
            .test()
            .assertError(ResumeErrors.GenericError::class.java)
            .assertErrorMessage(null)
    }


    @Test
    fun testGetInformationUnexpectedException() {
        whenever(resumeRepository.getResumeData())
            .thenReturn(Single.error(ResumeErrors.TimeoutException()))

        resumeRepository.getResumeData()
            .test()
            .assertError(ResumeErrors.TimeoutException::class.java)
            .assertErrorMessage(null)
    }

    private fun createWorkList(): List<PastJobData> {
        return listOf(PastJobData(WORK_COMPANY,
            WORK_POSITION,
            WORK_URL_IMAGE,
            WORK_START_DATE,
            WORK_END_DATE,
            WORK_SUMMARY))
    }

    private fun createSkillsList(): List<SkillsData> {
        return listOf(SkillsData(SKILL_NAME, SKILL_LEVEL, SKILL_KEYWORDS, SKILL_URL_IMAGE))
    }

    companion object {
        const val WORK_COMPANY = "workCompany"
        const val WORK_POSITION = "workPosition"
        const val WORK_URL_IMAGE = "workUrlImage"
        const val WORK_START_DATE = "workStartDate"
        const val WORK_END_DATE = "workEndDate"
        const val WORK_SUMMARY = "workSummary"
        const val SKILL_NAME = "skillName"
        const val SKILL_LEVEL = "skillLevel"
        val SKILL_KEYWORDS = listOf("android", "kotlin")
        const val SKILL_URL_IMAGE = "skillUrlImage"
    }
}