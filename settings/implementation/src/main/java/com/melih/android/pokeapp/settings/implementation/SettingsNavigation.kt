package com.melih.android.pokeapp.settings.implementation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.settingsDestination(route: String) {
    composable(route = route) {
        SettingsScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
