package com.example.myresume.presenter

import com.example.myresume.domain.models.BasicsData
import com.example.myresume.domain.models.SkillsData
import com.example.myresume.domain.models.PastJobData

interface ResumeActivityContract {

    interface Presenter {

        fun initView()
        fun downloadResume()
        fun disposeSubscriptions()
    }

    interface View {

        fun initView()
        fun renderBasicInformation(basicInformation: BasicsData)
        fun renderSkillsInformation(skillsInformation: List<SkillsData>)
        fun renderWorksInformation(pastJobInformation: List<PastJobData>)
    }
}