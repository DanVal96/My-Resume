package com.example.data.mappers

import com.example.data.models.Abilities
import com.example.data.models.cache.RealmAbilities
import io.realm.RealmList

class RealmSkillsMapper: Map<Abilities, RealmAbilities>() {

    override fun transform(value: Abilities): RealmAbilities {
        return RealmAbilities(value.name ?: "",
            value.level ?: "",
            RealmList(*(value.keywords ?: emptyList()).toTypedArray()))
    }
}