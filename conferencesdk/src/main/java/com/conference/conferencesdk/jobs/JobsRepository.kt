package com.conference.conferencesdk.jobs

import com.conference.conferencesdk.util.Result
import com.conference.conferencesdk.jobs.model.JobsResponse

/**
 * Created by Dinorah Tovar on 3/19/19.
 */
class JobsRepository
constructor(private val jobsLocalDataSource: JobsLocalDataSource, private val jobsRemoteDataSource: JobsRemoteDataSource) {

    suspend fun getJobs(): Result<List<JobsResponse>?> {
        return jobsRemoteDataSource.getJobs()
    }

}
