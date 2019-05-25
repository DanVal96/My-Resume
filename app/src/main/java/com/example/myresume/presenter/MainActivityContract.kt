package com.example.myresume.presenter

import com.example.myresume.domain.models.BasicsData
import com.example.myresume.domain.models.AbilitiesData
import com.example.myresume.domain.models.PastJobData

interface MainActivityContract {

    interface Presenter {

        fun initView()
        fun downloadResume()
        fun disposeSubscriptions()
    }

    interface View {

        fun initView()
        fun renderBasicInformation(basicInformation: BasicsData)
        fun renderSkillsInformation(abilitiesInformation: List<AbilitiesData>)
        fun renderWorksInformation(pastJobInformation: List<PastJobData>)
    }
}