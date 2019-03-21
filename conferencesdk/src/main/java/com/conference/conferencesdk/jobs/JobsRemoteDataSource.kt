package com.conference.conferencesdk.jobs

import com.conference.conferencesdk.JobsInjector
import com.conference.conferencesdk.jobs.model.JobsResponse
import com.conference.conferencesdk.util.safeApiCall
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject
import com.conference.conferencesdk.util.Result

/**
 * Created by Dinorah Tovar on 3/19/19.
 */
class JobsRemoteDataSource {

    @Inject
    internal lateinit var retrofit: Retrofit

    /**
     * Injects Dagger on Construction
     */
    init {
        JobsInjector.dataComponent?.inject(this)
    }

    /**
     * Injects Dagger on Construction
     */
    init {
        JobsInjector.dataComponent?.inject(this)
    }

    suspend fun getJobs() = safeApiCall(
        call = {
            val response = retrofit
                .create(JobsService::class.java)
                .getJobs()
                .await()
            if (response.isSuccessful) {
                return@safeApiCall Result.Success(response.body())
            }
            return@safeApiCall Result.Error(0)
        },
        errorMessage = 0
    )

    /**
     * Interfaces to the web services
     */
    private interface JobsService {
        @GET("positions.json?search=node")
        fun getJobs(): Deferred<Response<List<JobsResponse>>>
    }

}
