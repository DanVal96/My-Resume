package com.example.data.mappers

import com.example.data.models.Basics
import com.example.data.models.cache.RealmResume
import com.example.data.models.cache.RealmAbilities
import com.example.data.models.cache.RealmPastJob
import com.example.data.remote.ResumeResponse
import io.realm.RealmList

class RealmResumeMapper: Map<ResumeResponse, RealmResume>() {

    override fun transform(value: ResumeResponse): RealmResume {
        val realmPastJobs: RealmList<RealmPastJob> = RealmList(*RealmWorkMapper()
            .transformCollection(value.pastJob ?: emptyList())
            .toTypedArray())
        val realmSkills: RealmList<RealmAbilities> = RealmList(*RealmSkillsMapper()
            .transformCollection(value.abilities ?: emptyList())
            .toTypedArray())
        return RealmResume(RealmBasicsMapper().transform(value.basics
            ?: Basics("", "", "", "", "")),
            realmPastJobs,
            realmSkills)
    }
}