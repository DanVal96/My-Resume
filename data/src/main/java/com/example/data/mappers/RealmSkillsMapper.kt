package com.example.data.mappers

import com.example.data.models.Skills
import com.example.data.models.cache.RealmAbilities
import io.realm.RealmList

class RealmSkillsMapper: Map<Skills, RealmAbilities>() {

    override fun transform(value: Skills): RealmAbilities {
        return RealmAbilities(value.name ?: "",
            value.level ?: "",
            RealmList(*(value.keywords ?: emptyList()).toTypedArray()))
    }
}