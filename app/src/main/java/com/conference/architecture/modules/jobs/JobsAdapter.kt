package com.conference.architecture.modules.jobs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.conference.architecture.R
import com.conference.architecture.holder.JobsHolder
import com.conference.conferencesdk.jobs.model.JobsResponse

/**
 * Created by Dinorah Tovar on 3/20/19.
 */
class JobsAdapter : RecyclerView.Adapter<JobsHolder>() {

    var jobsAvailable: List<JobsResponse?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsHolder {
        return JobsHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_jobs_row, parent, false))
    }

    /**
     * onBindViewHolder
     * @param holder ProjectHolder
     * @param position Int
     */
    override fun onBindViewHolder(holder: JobsHolder, position: Int) {
        holder.setValues(jobsAvailable?.get(position))
    }

    /**
     * getItemCount plus one
     * @return Int
     */
    override fun getItemCount(): Int {
        return jobsAvailable?.size ?: 0
    }

}
