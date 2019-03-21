package com.conference.conferencesdk.jobs

import com.conference.conferencesdk.JobsInjector

/**
 * Created by Dinorah Tovar on 3/19/19.
 * Local storage that has all the information from the user
 */
class JobsLocalDataSource {

    /**
     * Injects Dagger on Construction
     */
    init {
        JobsInjector.dataComponent?.inject(this)
    }

}
