package com.example.data.mappers

import com.example.data.models.PersonalInfo
import com.example.data.models.cache.RealmBasics

class RealmBasicsMapper: Map<PersonalInfo, RealmBasics>() {

    override fun transform(value: PersonalInfo): RealmBasics {

        return RealmBasics(value.name ?: "",
            value.title ?: "",
            value.urlImage ?: "",
            value.email ?: "",
            value.profile ?: "")
    }
}