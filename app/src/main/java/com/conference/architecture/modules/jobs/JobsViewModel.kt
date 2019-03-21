package com.conference.architecture.modules.jobs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.conference.architecture.JobsApplication
import com.conference.conferencesdk.util.Result
import com.conference.conferencesdk.jobs.JobsRepository
import com.conference.conferencesdk.jobs.model.JobsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Dinorah Tovar on 3/20/19.
 */
class JobsViewModel : ViewModel()  {

    @Inject
    internal lateinit var jobsRepository: JobsRepository

    val jobsLiveData: MutableLiveData<List<JobsResponse?>> by lazy { MutableLiveData<List<JobsResponse?>>() }

    /**
     * Init injector for main class
     */
    init {
        JobsApplication.appComponent?.inject(this)
    }

    fun getJobs() = CoroutineScope(Dispatchers.IO).launch {
        val response = jobsRepository.getJobs()
        withContext(Dispatchers.Main) {
            when (response) {
                is Result.Success -> jobsLiveData.value = response.data
            }
        }
    }

}
