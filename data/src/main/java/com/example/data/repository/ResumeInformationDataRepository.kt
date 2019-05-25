package com.example.data.repository

import com.example.myresume.domain.models.ResumeData
import com.example.myresume.domain.repository.ResumeRepository
import com.example.data.local.CacheDataSource
import com.example.data.mappers.ResumeDataMapper
import com.example.data.remote.ResumeResponse
import com.example.data.services.ResumeApiServices
import com.example.myresume.domain.errors.ResumeErrors
import io.reactivex.Single
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeInformationDataRepository @Inject constructor(
    val resumeServices: ResumeApiServices,
    val cacheDataSource: CacheDataSource
): ResumeRepository {

    override fun getResumeData(): Single<ResumeData> {
        return resumeServices.getResumeInformation()
                .map {
                    saveDataInCache(it)
                    ResumeDataMapper().transform(it)
                }.onErrorResumeNext{ getCachedData() }
    }

    private fun getCachedData(): Single<ResumeData> {
        return cacheDataSource.getCacheResumeInformation()
            .onErrorResumeNext { error ->
                when (error) {
                    is SocketTimeoutException -> Single.error(ResumeErrors.TimeoutException())
                    else -> Single.error(ResumeErrors.GenericError())
                }
            }
    }

    private fun saveDataInCache(resumeResponse: ResumeResponse) {
        cacheDataSource.storeReceivedData(resumeResponse)
    }
}