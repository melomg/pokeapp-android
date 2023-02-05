package com.melih.android.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.core.navigation.find
import com.melih.android.pokeapp.favourites.api.router.FavouritesRouter
import com.melih.android.pokeapp.pokemons.api.router.PokemonsRouter

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
        with(routers.find<PokemonsRouter>()) {
            composable(navController, routers)
        }
        with(routers.find<FavouritesRouter>()) {
            composable(navController, routers)
        }
    }
}
