package com.example.myresume.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myresume.R
import com.example.myresume.domain.models.SkillsData
import com.example.myresume.services.ImageDownloader

class AdapterResumeSkills(private var skillsList: MutableList<SkillsData>?,
                             private val imageDownloader: ImageDownloader)
    : RecyclerView.Adapter<AdapterResumeSkills.SkillViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        return SkillViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ability, parent, false))
    }

    override fun getItemCount(): Int {
        return skillsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.setSKillInfo(skillsList?.get(position) ?:
        SkillsData("", "0", emptyList(), "http://chittagongit.com/images/20x20-icon/20x20-icon-27.jpg")
            , imageDownloader)
    }

    fun refreshData(skillsList: MutableList<SkillsData>?) {
        skillsList?.let {
            if (this.skillsList == null) {
                this.skillsList = it
            } else {
                this.skillsList?.clear()
                this.skillsList?.addAll(it)
            }
            notifyDataSetChanged()
        }
    }

    class SkillViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvSkillTitle: TextView = view.findViewById(R.id.tv_profile_main_skill)
        private val tvSkillIcon: ImageView = view.findViewById(R.id.iv_skill_icon)
        private var skillsRecyclerView: RecyclerView? = view.findViewById(R.id.skills_list)
        private var adapterResumeAbilitiesKeywords: AdapterResumeAbilitiesKeywords? = null

        fun setSKillInfo(skillData: SkillsData, imageDownloader: ImageDownloader) {
            tvSkillTitle.text = skillData.name
            imageDownloader.loadImage(tvSkillIcon, skillData.urlImage)
            renderSkillsInformation(skillData.keywords?.toMutableList())
        }

        private fun renderSkillsInformation(abilitiesInformation: MutableList<String>?) {
            if (adapterResumeAbilitiesKeywords == null) {
                adapterResumeAbilitiesKeywords = AdapterResumeAbilitiesKeywords(abilitiesInformation)
                skillsRecyclerView?.apply {
                    layoutManager = LinearLayoutManager(this.context)
                    adapter = adapterResumeAbilitiesKeywords
                }
            } else {
                adapterResumeAbilitiesKeywords?.refreshData(abilitiesInformation)
            }
        }
    }
}