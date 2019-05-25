package com.example.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0015H\u0007J\b\u0010\u0018\u001a\u00020\u0015H\u0007J\b\u0010\u0019\u001a\u00020\u0015H\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/data/repository/ResumeDataRepositoryTest;", "", "()V", "realmDatasource", "Lcom/example/data/local/CacheDataSource;", "resumeApiServices", "Lcom/example/data/services/ResumeApiServices;", "resumeRepository", "Lcom/example/myresume/domain/repository/ResumeRepository;", "createBasicsDataFromCache", "Lcom/example/myresume/domain/models/BasicsData;", "getAbilities", "", "Lcom/example/data/models/Abilities;", "getAbilitiesListFromCache", "Lcom/example/myresume/domain/models/AbilitiesData;", "getJobsList", "Lcom/example/data/models/PastJob;", "pastJobListFromCache", "Lcom/example/myresume/domain/models/PastJobData;", "setUp", "", "testGetInformationSuccessful", "testGetInformationTimeoutError", "testGetInformationUnexpectedException", "testGetResumeFromFallbackCache", "Companion", "data_debug"})
public final class ResumeDataRepositoryTest {
    @org.mockito.Mock()
    private com.example.data.services.ResumeApiServices resumeApiServices;
    @org.mockito.Mock()
    private com.example.data.local.CacheDataSource realmDatasource;
    private com.example.myresume.domain.repository.ResumeRepository resumeRepository;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_NAME = "jobName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_POSITION = "jobPosition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_LOGO = "jobLogo";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_START_DATE = "jobStartDate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_END_DATE = "jobEndDate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JOB_SUMMARY = "jobSummary";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ABILITY = "ability";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ABILITY_LEVEL = "abilityLevel";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> ABILITIES_KEYWORDS = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASICS_NAME = "name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASICS_LABEL = "label";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASICS_PICTURE = "picture";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASICS_EMAIL = "email";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASICS_SUMMARY = "summary";
    public static final com.example.data.repository.ResumeDataRepositoryTest.Companion Companion = null;
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void testGetInformationTimeoutError() {
    }
    
    @org.junit.Test()
    public final void testGetInformationSuccessful() {
    }
    
    @org.junit.Test()
    public final void testGetResumeFromFallbackCache() {
    }
    
    @org.junit.Test()
    public final void testGetInformationUnexpectedException() {
    }
    
    private final java.util.List<com.example.data.models.PastJob> getJobsList() {
        return null;
    }
    
    private final java.util.List<com.example.data.models.Abilities> getAbilities() {
        return null;
    }
    
    private final java.util.List<com.example.myresume.domain.models.AbilitiesData> getAbilitiesListFromCache() {
        return null;
    }
    
    private final java.util.List<com.example.myresume.domain.models.PastJobData> pastJobListFromCache() {
        return null;
    }
    
    private final com.example.myresume.domain.models.BasicsData createBasicsDataFromCache() {
        return null;
    }
    
    public ResumeDataRepositoryTest() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/data/repository/ResumeDataRepositoryTest$Companion;", "", "()V", "ABILITIES_KEYWORDS", "", "", "getABILITIES_KEYWORDS", "()Ljava/util/List;", "ABILITY", "ABILITY_LEVEL", "BASICS_EMAIL", "BASICS_LABEL", "BASICS_NAME", "BASICS_PICTURE", "BASICS_SUMMARY", "JOB_END_DATE", "JOB_LOGO", "JOB_NAME", "JOB_POSITION", "JOB_START_DATE", "JOB_SUMMARY", "data_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getABILITIES_KEYWORDS() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}