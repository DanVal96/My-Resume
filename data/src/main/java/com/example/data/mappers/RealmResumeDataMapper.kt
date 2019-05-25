package com.example.data.mappers

import com.example.myresume.domain.models.*
import com.example.data.models.cache.*

class RealmResumeDataMapper: Map<RealmResume, ResumeData> () {

    override fun transform(value: RealmResume): ResumeData {

        return ResumeData(
            value.basics?.let { RealmBasicsDataMapper().transform(it) },
            RealmPastJobDataMapper().transformCollection(value.pastJob.toList()),
            RealSkillsDataMapper().transformCollection(value.skills.toList()))
    }

    class RealmBasicsDataMapper: Map<RealmBasics, BasicsData>() {

        override fun transform(value: RealmBasics): BasicsData {
            return BasicsData(value.name,
                value.label,
                value.picture,
                value.email,
                value.summary)
        }
    }

    class RealmPastJobDataMapper: Map<RealmPastJob, PastJobData>() {

        override fun transform(value: RealmPastJob): PastJobData {
            return PastJobData(value.company,
                value.position,
                value.urlImage,
                value.startDate,
                value.endDate,
                value.summary)
        }
    }

    class RealSkillsDataMapper: Map<RealmSkills, SkillsData>() {

        override fun transform(value: RealmSkills): SkillsData {
            return SkillsData(value.name,
                value.level,
                value.keywords.toList(),
                value.urlImage)
        }
    }
}