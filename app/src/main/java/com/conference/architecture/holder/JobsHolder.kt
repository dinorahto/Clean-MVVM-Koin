package com.conference.architecture.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.conference.architecture.util.setImage
import com.conference.conferencesdk.jobs.model.JobsResponse
import kotlinx.android.synthetic.main.layout_jobs_row.view.*

/**
 * Created by Dinorah Tovar on 3/20/19.
 */
class JobsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setValues (job: JobsResponse?) {
        itemView.job_company_logo.setImage(job?.company_logo)
        itemView.job_name.text = job?.company
        itemView.job_title.text = job?.title
        itemView.job_type.text = job?.type
        itemView.job_where.text = job?.location
    }
}
