package com.example.data.mappers

import com.example.myresume.domain.models.*
import com.example.data.models.Basics
import com.example.data.models.Abilities
import com.example.data.models.PastJob
import com.example.data.remote.ResumeResponse

class ResumeDataMapper: Map<ResumeResponse, ResumeData>() {

    override fun transform(value: ResumeResponse): ResumeData {
        val basicsMapper = BasicsDataMapper()
        val pastJobsMapper = PastJobsMapper()
        val abilitiesMapper = AbilitiesMapper()
        return ResumeData(
                value.basics?.let { basicsMapper.transform(it) },
                value.pastJob?.let { pastJobsMapper.transformCollection(it) },
                value.abilities?.let { abilitiesMapper.transformCollection(it) })
    }

    class BasicsDataMapper: Map<Basics, BasicsData>() {
        override fun transform(value: Basics): BasicsData {
            return BasicsData(value.name,
                    value.label,
                    value.picture,
                    value.email,
                    value.summary)
        }
    }

    class PastJobsMapper: Map<PastJob, PastJobData>() {

        override fun transform(value: PastJob): PastJobData {
            return PastJobData(value.company,
                    value.position,
                    value.urlImage,
                    value.startDate,
                    value.endDate,
                    value.summary)
        }
    }

    class AbilitiesMapper: Map<Abilities, AbilitiesData>() {

        override fun transform(value: Abilities): AbilitiesData {
            return AbilitiesData(value.name, value.level, value.keywords)
        }
    }
}