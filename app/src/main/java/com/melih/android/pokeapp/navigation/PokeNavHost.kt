package com.melih.android.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.core.navigation.find
import com.melih.android.pokeapp.favourites.api.router.FavouritesRouter
import com.melih.android.pokeapp.pokemons.api.router.PokemonsNestedRouter
import com.melih.android.pokeapp.settings.api.router.SettingsRouter

@Composable
internal fun PokeNavHost(
    navController: NavHostController,
    routers: Routers,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        with(routers.find<PokemonsNestedRouter>()) {
            navigation(navController, routers)
        }
        with(routers.find<FavouritesRouter>()) {
            composable(navController, routers)
        }
        with(routers.find<SettingsRouter>()) {
            composable(navController, routers)
        }
    }
}
