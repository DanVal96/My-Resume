package com.example.data.mappers

import com.example.data.models.Skills
import com.example.data.models.cache.RealmSkills
import io.realm.RealmList

class RealmSkillsMapper: Map<Skills, RealmSkills>() {

    override fun transform(value: Skills): RealmSkills {
        return RealmSkills(value.name ?: "",
            value.level ?: "",
            RealmList(*(value.keywords ?: emptyList()).toTypedArray()),
            value.urlImage ?: "")
    }
}