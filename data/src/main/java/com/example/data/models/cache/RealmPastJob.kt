package com.example.data.models.cache

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class RealmPastJob(): RealmObject() {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var company: String = ""
    var position: String = ""
    var urlImage: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var summary: String = ""

    constructor(company: String,
                position: String,
                urlImage: String,
                startDate: String,
                endDate: String,
                summary: String): this() {
        this.company = company
        this.position = position
        this.urlImage = urlImage
        this.startDate = startDate
        this.endDate = endDate
        this.summary = summary
    }
}