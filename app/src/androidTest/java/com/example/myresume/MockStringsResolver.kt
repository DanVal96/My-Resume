package com.example.myresume

import com.example.myresume.domain.resolver.StringsResolver

class MockStringsResolver: StringsResolver {

    override fun getTimeOutExceededString(): String {
        return EMPTY_STRING
    }

    override fun getUnknownExceptionString(): String {
        return EMPTY_STRING
    }

    override fun getSkillsHeader(): String {
        return EMPTY_STRING
    }

    override fun getWorkPeriodFormat(startDate: String?, endDate: String?): String {
        return EMPTY_STRING
    }

    companion object {
        const val EMPTY_STRING = ""
    }
}