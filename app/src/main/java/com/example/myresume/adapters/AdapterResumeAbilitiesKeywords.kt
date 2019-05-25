package com.example.myresume.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myresume.R

class AdapterResumeAbilitiesKeywords(private var skillsList: MutableList<String>?)
    : RecyclerView.Adapter<AdapterResumeAbilitiesKeywords.SkillKeywordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillKeywordViewHolder {
        return SkillKeywordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ability_keyword, parent, false))
    }

    override fun getItemCount(): Int {
        return skillsList?.size ?: 0
    }

    override fun onBindViewHolder(holderKeyword: SkillKeywordViewHolder, position: Int) {
        holderKeyword.setSKillName(skillsList?.get(position) ?: "")
    }

    fun refreshData(skillsList: MutableList<String>?) {
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

    class SkillKeywordViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvSkillName: TextView = view.findViewById(R.id.tv_skill)

        fun setSKillName(skillName: String) {
            tvSkillName.text = skillName
        }
    }
}