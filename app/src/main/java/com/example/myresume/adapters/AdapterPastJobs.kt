package com.example.myresume.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myresume.R
import com.example.myresume.domain.models.PastJobData
import com.example.myresume.domain.resolver.StringsResolver

class AdapterPastJobs(private var worksList: ArrayList<PastJobData>?,
                      private val resourceManager: StringsResolver)
    : RecyclerView.Adapter<AdapterPastJobs.PreviousWorkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviousWorkViewHolder {
        return PreviousWorkViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_past_job, parent, false))
    }

    override fun onBindViewHolder(holder: PreviousWorkViewHolder, position: Int) {
        worksList?.let { holder.setWorkInformation(it[position], resourceManager) }
    }

    fun loadData(newWorksList: ArrayList<PastJobData>?) {
        newWorksList?.let {
            if (this.worksList == null) {
                worksList = it
            } else {
                worksList?.clear()
                worksList?.addAll(it)
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return worksList?.size ?: 0
    }

    class PreviousWorkViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvJobPosition = view.findViewById<TextView>(R.id.tv_job_position)
        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvPeriod = view.findViewById<TextView>(R.id.tv_work_period)
        private val tvPositionSummary = view.findViewById<TextView>(R.id.tv_position_summary)

        fun setWorkInformation(pastJobInformation: PastJobData,
                               resourceManager: StringsResolver) {
            pastJobInformation.run {
                tvJobPosition.text = position
                tvName.text = company
                tvPeriod.text = resourceManager.getWorkPeriodFormat(startDate, endDate)
                tvPositionSummary.text = summary
            }
        }
    }
}