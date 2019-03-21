package com.conference.conferencesdk

import com.conference.conferencesdk.jobs.JobsLocalDataSource
import com.conference.conferencesdk.jobs.JobsRemoteDataSource

/**
 * Created by Dinorah Tovar on 3/19/19.
 */
interface DataComponent {
    fun inject(jobsRemoteDataSource: JobsRemoteDataSource)
    fun inject(jobsLocalDataSource: JobsLocalDataSource)
}
