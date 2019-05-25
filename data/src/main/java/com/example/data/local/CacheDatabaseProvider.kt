package com.example.data.local

import io.realm.Realm

interface CacheDatabaseProvider {
    val realmInstance: Realm
}