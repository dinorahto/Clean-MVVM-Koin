package com.conference.architecture

import android.app.Application
import com.conference.conferencesdk.JobsInjector
import com.conference.conferencesdk.DataModule
import dagger.Module

/**
 * Created by Dinorah Tovar on 3/19/19.
 * Application class to set up control of the app
 */
@Module
class JobsApplication : Application() {

    /**
     * Companion Object with static objects
     */
    companion object {
        var appComponent: AppComponent? = null
    }

    /**
     * Initializes Fabric, Realm and Dagger component
     */
    override fun onCreate() {
        super.onCreate()

        /*Realm.init(this)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)*/

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dataModule(DataModule("https://jobs.github.com/"))
            .build()

        JobsInjector.context = this
        JobsInjector.dataComponent = appComponent
    }

}
