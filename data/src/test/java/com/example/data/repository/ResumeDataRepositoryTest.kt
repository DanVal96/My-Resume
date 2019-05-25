package com.example.data.repository

import com.example.myresume.domain.models.*
import com.example.myresume.domain.repository.ResumeRepository
import com.example.data.local.CacheDataSource
import com.example.data.models.PersonalInfo
import com.example.data.models.Skills
import com.example.data.models.WorkExperience
import com.example.data.remote.ResumeResponse
import com.example.data.services.ResumeApiServices
import com.example.myresume.domain.errors.ResumeErrors
import io.reactivex.Single
import org.junit.Assert.assertEquals

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.net.SocketTimeoutException
import org.mockito.Mockito.`when` as whenever

class ResumeDataRepositoryTest {

    @Mock
    private lateinit var resumeApiServices: ResumeApiServices
    @Mock
    private lateinit var realmDatasource: CacheDataSource

    private lateinit var resumeRepository: ResumeRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resumeRepository = ResumeInformationDataRepository(resumeApiServices, realmDatasource)
    }

    @Test
    fun testGetInformationTimeoutError() {
        whenever(resumeApiServices.getResumeInformation()).thenReturn(Single.error(SocketTimeoutException()))
        whenever(realmDatasource.getCacheResumeInformation()).thenReturn(Single.just(ResumeData()))

        resumeRepository.getResumeData()
            .test()
            .assertComplete()
    }

    @Test
    fun testGetInformationSuccessful() {
        val basicsResponse = PersonalInfo("name",
            "title",
            "urlImage",
            "email",
            "profile")
        val worksResponse = getJobsList()
        val skillsResponse = getAbilities()
        val response = ResumeResponse(basicsResponse,
            worksResponse,
            skillsResponse)

        whenever(resumeApiServices.getResumeInformation()).thenReturn(Single.just(response))
        //put here the return for the local source to check both cases

        val receivedResponse = resumeRepository.getResumeData().test().assertComplete().values()[0]
        val receivedBasics = receivedResponse.basics
        val receivedWork = receivedResponse.pastJob?.get(0)
        val receivedSkill = receivedResponse.skills?.get(0)
        assertEquals(receivedBasics?.name, basicsResponse.name)
        assertEquals(receivedBasics?.label, basicsResponse.title)
        assertEquals(receivedBasics?.picture, basicsResponse.urlImage)
        assertEquals(receivedBasics?.email, basicsResponse.email)
        assertEquals(receivedBasics?.summary, basicsResponse.profile)
        assertEquals(receivedWork?.company, JOB_NAME)
        assertEquals(receivedWork?.position, JOB_POSITION)
        assertEquals(receivedWork?.startDate, JOB_START_DATE)
        assertEquals(receivedWork?.endDate, JOB_END_DATE)
        assertEquals(receivedWork?.urlImage, JOB_LOGO)
        assertEquals(receivedWork?.summary, JOB_SUMMARY)
        assertEquals(receivedSkill?.name, ABILITY)
        assertEquals(receivedSkill?.level, ABILITY_LEVEL)
        assertEquals(receivedSkill?.keywords?.size, ABILITIES_KEYWORDS.size)

        verify(realmDatasource).storeReceivedData(response)
    }

    @Test
    fun testGetResumeFromFallbackCache() {
        val basicsResponse = createBasicsDataFromCache()
        val jobsResponse = pastJobListFromCache()
        val abilitiesData = getAbilitiesListFromCache()
        val response = ResumeData(basicsResponse,
            jobsResponse,
            abilitiesData)

        whenever(resumeApiServices.getResumeInformation()).thenReturn(Single.error(SocketTimeoutException()))
        whenever(realmDatasource.getCacheResumeInformation()).thenReturn(Single.just(response))
        //put here the return for the local source to check both cases

        val receivedResponse = resumeRepository.getResumeData().test().assertComplete().values()[0]
        val receivedBasics = receivedResponse.basics
        val receivedWork = receivedResponse.pastJob?.get(0)
        val receivedSkill = receivedResponse.skills?.get(0)
        assertEquals(receivedBasics?.name, basicsResponse.name)
        assertEquals(receivedBasics?.label, basicsResponse.label)
        assertEquals(receivedBasics?.picture, basicsResponse.picture)
        assertEquals(receivedBasics?.email, basicsResponse.email)
        assertEquals(receivedBasics?.summary, basicsResponse.summary)
        assertEquals(receivedWork?.company, JOB_NAME)
        assertEquals(receivedWork?.position, JOB_POSITION)
        assertEquals(receivedWork?.startDate, JOB_START_DATE)
        assertEquals(receivedWork?.endDate, JOB_END_DATE)
        assertEquals(receivedWork?.urlImage, JOB_LOGO)
        assertEquals(receivedWork?.summary, JOB_SUMMARY)
        assertEquals(receivedSkill?.name, ABILITY)
        assertEquals(receivedSkill?.level, ABILITY_LEVEL)
        assertEquals(receivedSkill?.keywords?.size, ABILITIES_KEYWORDS.size)
    }

    @Test
    fun testGetInformationUnexpectedException() {
        whenever(resumeApiServices.getResumeInformation()).thenReturn(Single.error(Exception()))
        whenever(realmDatasource.getCacheResumeInformation()).thenReturn(Single.error(IllegalStateException()))

        resumeRepository.getResumeData()
            .test()
            .assertError(ResumeErrors.GenericError::class.java)

        verify(realmDatasource).getCacheResumeInformation()
    }

    private fun getJobsList(): List<WorkExperience> {
        return listOf(WorkExperience(JOB_NAME,
            JOB_POSITION,
            JOB_LOGO,
            JOB_START_DATE,
            JOB_END_DATE,
            JOB_SUMMARY))
    }

    private fun getAbilities(): List<Skills> {
        return listOf(Skills(ABILITY, ABILITY_LEVEL, ABILITIES_KEYWORDS))
    }

    private fun getAbilitiesListFromCache(): List<AbilitiesData> {
        return listOf(AbilitiesData(ABILITY, ABILITY_LEVEL, ABILITIES_KEYWORDS))
    }

    private fun pastJobListFromCache(): List<PastJobData> {
        return listOf(PastJobData(JOB_NAME,
            JOB_POSITION,
            JOB_LOGO,
            JOB_START_DATE,
            JOB_END_DATE,
            JOB_SUMMARY))
    }

    private fun createBasicsDataFromCache(): BasicsData {
        return BasicsData(BASICS_NAME,
            BASICS_LABEL,
            BASICS_PICTURE,
            BASICS_EMAIL,
            BASICS_SUMMARY)
    }

    companion object {
        const val JOB_NAME = "jobName"
        const val JOB_POSITION = "jobPosition"
        const val JOB_LOGO = "jobLogo"
        const val JOB_START_DATE = "jobStartDate"
        const val JOB_END_DATE = "jobEndDate"
        const val JOB_SUMMARY = "jobSummary"
        const val ABILITY = "ability"
        const val ABILITY_LEVEL = "abilityLevel"
        val ABILITIES_KEYWORDS = listOf("android", "kotlin")
        const val BASICS_NAME = "name"
        const val BASICS_LABEL = "title"
        const val BASICS_PICTURE = "urlImage"
        const val BASICS_EMAIL = "email"
        const val BASICS_SUMMARY = "profile"
    }
}