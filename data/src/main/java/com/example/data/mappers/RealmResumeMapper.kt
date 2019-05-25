package com.example.data.mappers

import com.example.data.models.PersonalInfo
import com.example.data.models.cache.RealmResume
import com.example.data.models.cache.RealmSkills
import com.example.data.models.cache.RealmPastJob
import com.example.data.remote.ResumeResponse
import io.realm.RealmList

class RealmResumeMapper: Map<ResumeResponse, RealmResume>() {

    override fun transform(value: ResumeResponse): RealmResume {
        val realmPastJobs: RealmList<RealmPastJob> = RealmList(*RealmWorkMapper()
            .transformCollection(value.workExperience ?: emptyList())
            .toTypedArray())
        val realmSkills: RealmList<RealmSkills> = RealmList(*RealmSkillsMapper()
            .transformCollection(value.skills ?: emptyList())
            .toTypedArray())
        return RealmResume(RealmBasicsMapper().transform(value.personalInfo
            ?: PersonalInfo("", "", "", "", "")),
            realmPastJobs,
            realmSkills)
    }
}