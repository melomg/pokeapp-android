package com.melih.android.pokeapp.core.result.ext

import timber.log.Timber

inline fun <reified R> Result<R>.alsoLogError(): Result<R> = also {
    it.onFailure { exception ->
        Timber.e(exception, R::class.java.name)
    }
}
