package com.example.data.mappers

import com.example.data.models.WorkExperience
import com.example.data.models.cache.RealmPastJob

class RealmWorkMapper: Map<WorkExperience, RealmPastJob>() {

    override fun transform(value: WorkExperience): RealmPastJob {
        return RealmPastJob(value.company ?: "",
            value.position ?: "",
            value.urlImage ?: "",
            value.periodStart ?: "",
            value.periodEnd ?: "",
            value.summary ?: "")
    }
}