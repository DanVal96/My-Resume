package com.example.data.local

import com.example.myresume.domain.models.ResumeData
import com.example.data.mappers.RealmResumeMapper
import com.example.data.mappers.RealmResumeDataMapper
import com.example.data.models.cache.RealmResume
import com.example.data.remote.ResumeResponse
import com.example.myresume.domain.errors.ResumeErrors
import io.reactivex.Single

class RealmCacheDataSource(private val realmProviderCache: CacheDatabaseProvider): CacheDataSource {

    override fun storeReceivedData(resumeResponse: ResumeResponse) {
        realmProviderCache.realmInstance.use { realm ->
            realm.executeTransaction {
                it.deleteAll()
                val realmResume: RealmResume = RealmResumeMapper().transform(resumeResponse)
                it.copyToRealmOrUpdate(realmResume)
            }
        }
    }

    override fun getCacheResumeInformation(): Single<ResumeData> {
        return Single.fromCallable {
            return@fromCallable realmProviderCache.realmInstance.use {
                val realmResults = it.where(RealmResume::class.java).findFirst()
                if (realmResults == null) {
                    throw ResumeErrors.GenericError()
                } else {
                    RealmResumeDataMapper().transform(realmResults)
                }
            }
        }
    }
}