package com.example.data.mappers

import com.example.data.models.PastJob
import com.example.data.models.cache.RealmPastJob

class RealmWorkMapper: Map<PastJob, RealmPastJob>() {

    override fun transform(value: PastJob): RealmPastJob {
        return RealmPastJob(value.company ?: "",
            value.position ?: "",
            value.urlImage ?: "",
            value.startDate ?: "",
            value.endDate ?: "",
            value.summary ?: "")
    }
}