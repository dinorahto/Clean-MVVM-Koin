package com.conference.conferencesdk

import android.app.Application

/**
 * Created by Dinorah Tovar on 12/5/18.
 * Injects the App Component
 */

class JobsInjector {

    /**
     * CompanionObject
     * Setting DaggerAppComponent and DataModule
     * @link https://github.com/google/dagger
     */
    companion object {
        lateinit var context: Application
        var dataComponent: DataComponent? = null
    }

}
