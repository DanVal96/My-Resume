package com.example.myresume

import com.example.myresume.domain.models.BasicsData
import com.example.myresume.domain.models.PastJobData
import com.example.myresume.domain.models.ResumeData
import com.example.myresume.domain.models.SkillsData
import com.example.myresume.domain.repository.ResumeRepository
import io.reactivex.Single

class MockResumeInformationRepository: ResumeRepository {

    override fun getResumeData(): Single<ResumeData> {
        return Single.just(ResumeData(getBasicMock(), getJobListMock(), getSkillsListMock()))
    }

    private fun getSkillsListMock(): List<SkillsData> {
        return listOf(SkillsData(SKILL, SKILL_LEVEL, SKILL_KEYWORDS, SKILL_URL_IMAGE))
    }

    private fun getJobListMock(): List<PastJobData> {
        return listOf(
            PastJobData(JOB_NAME,
                JOB_POSITION,
                JOB_LOGO,
                JOB_PERIOD_START,
                JOB_PERIOD_END,
                JOB_SUMMARY)
        )
    }

    private fun getBasicMock(): BasicsData {
        return BasicsData(BASICS_NAME,
            BASICS_TITLE,
            BASICS_URL_IMAGE,
            BASICS_EMAIL,
            BASICS_PROFILE)
    }

    companion object {
        const val JOB_NAME = "jobName"
        const val JOB_POSITION = "jobPosition"
        const val JOB_LOGO = "jobLogo"
        const val JOB_PERIOD_START = "jobPeriodStart"
        const val JOB_PERIOD_END = "jobPeriodEnd"
        const val JOB_SUMMARY = "jobSummary"
        const val SKILL = "skill"
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