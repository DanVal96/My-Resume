package com.example.data.mappers

import com.example.myresume.domain.models.*
import com.example.data.models.PersonalInfo
import com.example.data.models.Skills
import com.example.data.models.WorkExperience
import com.example.data.remote.ResumeResponse

class ResumeDataMapper: Map<ResumeResponse, ResumeData>() {

    override fun transform(value: ResumeResponse): ResumeData {
        val basicsMapper = BasicsDataMapper()
        val pastJobsMapper = PastJobsMapper()
        val skillsMapper = SkillsMapper()
        return ResumeData(
                value.personalInfo?.let { basicsMapper.transform(it) },
                value.workExperience?.let { pastJobsMapper.transformCollection(it) },
                value.skills?.let { skillsMapper.transformCollection(it) })
    }

    class BasicsDataMapper: Map<PersonalInfo, BasicsData>() {
        override fun transform(value: PersonalInfo): BasicsData {
            return BasicsData(value.name,
                    value.title,
                    value.urlImage,
                    value.email,
                    value.profile)
        }
    }

    class PastJobsMapper: Map<WorkExperience, PastJobData>() {

        override fun transform(value: WorkExperience): PastJobData {
            return PastJobData(value.company,
                    value.position,
                    value.urlImage,
                    value.periodStart,
                    value.periodEnd,
                    value.summary)
        }
    }

    class SkillsMapper: Map<Skills, SkillsData>() {

        override fun transform(value: Skills): SkillsData {
            return SkillsData(value.name, value.level, value.keywords, value.urlImage)
        }
    }
}