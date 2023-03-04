package com.melih.android.pokeapp.core.result.ext

import timber.log.Timber

fun <R> Result<R>.alsoLogError(message: String): Result<R> = also {
    it.onFailure { exception ->
        Timber.e(exception, message)
    }
}
