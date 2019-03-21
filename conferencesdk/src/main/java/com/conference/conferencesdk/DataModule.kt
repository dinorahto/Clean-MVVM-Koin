package com.conference.conferencesdk

import com.conference.conferencesdk.jobs.JobsLocalDataSource
import com.conference.conferencesdk.jobs.JobsRemoteDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Dinorah Tovar on 3/19/19.
 */
@Module
class DataModule(private val baseUrl: String, private val debugInterceptor: Interceptor?) {

    /**
     * CompanionObject
     */
    companion object {
        private val rxAdapter = CoroutineCallAdapterFactory()
        private const val readTimeOut = 20L
        private const val connectTimeOut = 20L
    }

    /**
     * OkHttpClient
     */
    @Provides
    @Singleton
    fun getUnsafeOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
        debugInterceptor?.let {
            builder.addNetworkInterceptor(debugInterceptor)
        }
        return builder.build()
    }

    /**
     * Gson Provider
     */
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        return gsonBuilder.create()
    }

    /**
     * Retrofit Provider
     */
    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideJobsRemoteDataSource(): JobsRemoteDataSource {
        return JobsRemoteDataSource()
    }

    @Provides
    @Singleton
    internal fun provideJobsLocalDataSource(): JobsLocalDataSource {
        return JobsLocalDataSource()
    }

}
