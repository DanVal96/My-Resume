package com.example.myresume

import com.example.myresume.domain.repository.ResumeRepository
import com.example.myresume.domain.resolver.StringsResolver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockAppModule {

    @Provides
    @Singleton
    fun providesStringResolver(): StringsResolver {
        return MockStringsResolver()
    }

    @Provides
    @Singleton
    fun providesResumeRepository(): ResumeRepository {
        return MockResumeInformationRepository()
    }
}