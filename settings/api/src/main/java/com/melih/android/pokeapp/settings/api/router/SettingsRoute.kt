package com.melih.android.pokeapp.settings.api.router

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.melih.android.pokeapp.settings.implementation.settingsDestination

const val settingsRoute = "settings_route"

fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    this.navigate(settingsRoute, navOptions)
}

fun NavGraphBuilder.createSettingsDestination() = settingsDestination(settingsRoute)
