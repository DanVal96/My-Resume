package com.example.myresume.resolver

import android.content.res.Resources
import com.example.myresume.R
import com.example.myresume.domain.resolver.StringsResolver

class ResumeStringsResolver(private val resources: Resources): StringsResolver {

    override fun getWorkPeriodFormat(startDate: String?, endDate: String?): String {
        return if (startDate.isNullOrEmpty() || endDate.isNullOrEmpty()) {
            EMPTY_STRING
        } else {
            resources.getString(R.string.text_date_template_format, startDate, endDate)
        }
    }

    override fun getTimeOutExceededString(): String {
        return resources.getString(R.string.exception_timeout)
    }

    override fun getUnknownExceptionString(): String {
        return resources.getString(R.string.exception_unknown)
    }

    override fun getSkillsHeader(): String {
        return EMPTY_STRING
    }

    companion object {
        const val EMPTY_STRING = ""
    }
}