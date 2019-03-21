package com.conference.architecture

import com.conference.architecture.modules.jobs.JobsViewModel
import com.conference.conferencesdk.DataComponent
import com.conference.conferencesdk.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Dinorah Tovar on 12/5/18.
 * Component to inject the Data Module and the App Module
 */
@Singleton
@Component(modules = [(DataModule::class), (AppModule::class)])
interface AppComponent : DataComponent {
    fun inject(jobViewModel: JobsViewModel)
}
