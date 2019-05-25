package com.example.data.models.cache

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class RealmSkills(): RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name : String = ""
    var level : String = ""
    var urlImage : String = ""
    @Required
    var keywords : RealmList<String> = RealmList()

    constructor(name: String, level: String, keywords: RealmList<String>, urlImage: String): this() {
        this.name = name
        this.level = level
        this.keywords = keywords
        this.urlImage = urlImage
    }
}