package com.example.data.mappers

import com.example.data.models.Basics
import com.example.data.models.cache.RealmBasics

class RealmBasicsMapper: Map<Basics, RealmBasics>() {

    override fun transform(value: Basics): RealmBasics {

        return RealmBasics(value.name ?: "",
            value.label ?: "",
            value.picture ?: "",
            value.email ?: "",
            value.summary ?: "")
    }
}