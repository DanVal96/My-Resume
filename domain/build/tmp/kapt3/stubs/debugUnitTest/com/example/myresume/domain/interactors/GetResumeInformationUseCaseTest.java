package com.example.myresume.domain.interactors;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u000fH\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/myresume/domain/interactors/GetResumeInformationUseCaseTest;", "", "()V", "postExecutorExecutor", "Lcom/example/myresume/domain/executor/UiThreadExecutor;", "resumeRepository", "Lcom/example/myresume/domain/repository/ResumeRepository;", "resumeUseCase", "Lcom/example/myresume/domain/interactors/GetResumeInteractor;", "createSkillsList", "", "Lcom/example/myresume/domain/models/AbilitiesData;", "createWorkList", "Lcom/example/myresume/domain/models/PastJobData;", "setUp", "", "testGetInformationTimeoutError", "testGetInformationUnexpectedException", "testGetResumeInformationSuccessful", "Companion", "domain_debug"})
public final class GetResumeInformationUseCaseTest {
    @org.mockito.Mock()
    private com.example.myresume.domain.repository.ResumeRepository resumeRepository;
    @org.mockito.Mock()
    private com.example.myresume.domain.executor.UiThreadExecutor postExecutorExecutor;
    private com.example.myresume.domain.interactors.GetResumeInteractor resumeUseCase;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_COMPANY = "workCompany";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_POSITION = "workPosition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_URL_IMAGE = "workUrlImage";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_START_DATE = "workStartDate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_END_DATE = "workEndDate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_SUMMARY = "workSummary";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SKILL_NAME = "skillName";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SKILL_LEVEL = "skillLevel";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> SKILL_KEYWORDS = null;
    public static final com.example.myresume.domain.interactors.GetResumeInformationUseCaseTest.Companion Companion = null;
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void testGetResumeInformationSuccessful() {
    }
    
    @org.junit.Test()
    public final void testGetInformationTimeoutError() {
    }
    
    @org.junit.Test()
    public final void testGetInformationUnexpectedException() {
    }
    
    private final java.util.List<com.example.myresume.domain.models.PastJobData> createWorkList() {
        return null;
    }
    
    private final java.util.List<com.example.myresume.domain.models.AbilitiesData> createSkillsList() {
        return null;
    }
    
    public GetResumeInformationUseCaseTest() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/myresume/domain/interactors/GetResumeInformationUseCaseTest$Companion;", "", "()V", "SKILL_KEYWORDS", "", "", "getSKILL_KEYWORDS", "()Ljava/util/List;", "SKILL_LEVEL", "SKILL_NAME", "WORK_COMPANY", "WORK_END_DATE", "WORK_POSITION", "WORK_START_DATE", "WORK_SUMMARY", "WORK_URL_IMAGE", "domain_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getSKILL_KEYWORDS() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}