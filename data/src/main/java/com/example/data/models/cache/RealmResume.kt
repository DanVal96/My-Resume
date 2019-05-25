package com.example.data.models.cache

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class RealmResume(): RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var basics: RealmBasics? = null
    var pastJob: RealmList<RealmPastJob> = RealmList()
    var skills: RealmList<RealmSkills> = RealmList()

    constructor(basics: RealmBasics, pastJobs: RealmList<RealmPastJob>, skills: RealmList<RealmSkills>): this() {
        this.basics = basics
        this.pastJob = pastJobs
        this.skills = skills
    }
}