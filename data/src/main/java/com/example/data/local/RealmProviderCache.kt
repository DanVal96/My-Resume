package com.example.data.local

import io.realm.Realm

class RealmProviderCache: CacheDatabaseProvider {
    override val realmInstance: Realm
        get() = Realm.getDefaultInstance()
}