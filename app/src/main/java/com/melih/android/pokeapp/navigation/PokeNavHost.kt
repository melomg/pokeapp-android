package com.melih.android.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
internal fun PokeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    //todo startDestination: String = settingsRoute
) {
// todo enable this when destinations created
//    NavHost(
//        navController = navController,
//        startDestination = startDestination,
//        modifier = modifier,
//    ) {
//        createPokemonsDestination()
//        createFavouritesDestination()
//        createSettingsDestination()
//    }
}
