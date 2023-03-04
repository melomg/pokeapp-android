package com.melih.android.pokeapp.core.result.ext

import timber.log.Timber

internal class TestTimber : Timber.Tree() {

    val logs = mutableListOf<Log>()

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        logs.add(Log(message, t))
    }

    data class Log(val message: String, val t: Throwable?)
}
