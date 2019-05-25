package com.example.myresume.domain.resolver;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/example/myresume/domain/resolver/StringsResolver;", "", "getSkillsHeader", "", "getTimeOutExceededString", "getUnknownExceptionString", "getWorkPeriodFormat", "startDate", "endDate", "domain_debug"})
public abstract interface StringsResolver {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTimeOutExceededString();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getUnknownExceptionString();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getSkillsHeader();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getWorkPeriodFormat(@org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @org.jetbrains.annotations.Nullable()
    java.lang.String endDate);
}