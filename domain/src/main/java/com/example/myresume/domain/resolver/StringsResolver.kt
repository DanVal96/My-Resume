package com.example.myresume.domain.resolver

interface StringsResolver {

    fun getTimeOutExceededString(): String
    fun getUnknownExceptionString(): String
    fun getSkillsHeader(): String
    fun getWorkPeriodFormat(startDate: String?, endDate: String?): String
}