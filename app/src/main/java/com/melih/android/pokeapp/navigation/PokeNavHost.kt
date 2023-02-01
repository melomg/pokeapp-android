package com.melih.android.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.melih.android.pokeapp.settings.api.router.createSettingsDestination
import com.melih.android.pokeapp.settings.api.router.settingsRoute

@Composable
internal fun PokeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = settingsRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        // todo createPokemonsDestination()
        // todo createFavouritesDestination()
        createSettingsDestination()
    }
}
