package com.melih.android.pokeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PokeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeTimber()
    }

    private fun initializeTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
