package com.conference.conferencesdk.util

/**
 * Created by Dinorah Tovar on 12/10/18.
 * Wrap a suspending API [call] in try/catch. In case an exception is thrown, a [Result.Error] is
 * created based on the [errorMessage].
 * An exception was thrown when calling the API so we're converting this to an IOException
 */
suspend fun <T : Any?> safeApiCall(call: suspend () -> Result<T>, errorMessage: Int): Result<T> {
    return try {
        call()
    } catch (e: Exception) {
        Result.Error(errorMessage)
    }
}
