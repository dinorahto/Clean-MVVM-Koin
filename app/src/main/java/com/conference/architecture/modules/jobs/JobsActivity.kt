package com.conference.architecture.modules.jobs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.conference.architecture.R
import com.conference.conferencesdk.jobs.model.JobsResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class JobsActivity : AppCompatActivity() {

    private var viewModel: JobsViewModel? = null
    private var adapterJobs: JobsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(JobsViewModel::class.java)
        setHeader()
        setAdapter()
        viewModel?.jobsLiveData?.observe(this, onJobsUpdate())
        viewModel?.getJobs()
    }

    private fun setHeader() {
        main_toolbar.toolbar_action_title.text = getString(R.string.title_jobs)
    }

    private fun setAdapter() {
        adapterJobs = JobsAdapter()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        main_recycler_view.layoutManager = layoutManager
        main_recycler_view.adapter = adapterJobs
    }

    private fun onJobsUpdate() = Observer<List<JobsResponse?>> { jobs ->
        adapterJobs?.jobsAvailable = jobs
        adapterJobs?.notifyDataSetChanged()
    }

}
