package com.conference.conferencesdk.util

/**
 * Created by Dinorah Tovar on 12/10/18.
 * A generic class that holds a value with they status
 * @param <T>
 */
sealed class Result<out T : Any?> {

    /**
     * A generic class that holds a value for Success
     */
    data class Success<out T : Any?>(val data: T) : Result<T>()

    /**
     * A generic class that holds a value for error
     */
    data class Error(val exception: Int) : Result<Nothing>()

    /**
     * Convert to string value
     */
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }

}
