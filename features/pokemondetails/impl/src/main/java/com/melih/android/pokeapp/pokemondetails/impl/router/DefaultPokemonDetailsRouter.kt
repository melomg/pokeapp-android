package com.melih.android.pokeapp.pokemondetails.impl.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.pokemondetails.api.router.PokemonDetailsRouter
import com.melih.android.pokeapp.pokemondetails.impl.ui.PokemonDetailsScreen
import javax.inject.Inject

class DefaultPokemonDetailsRouter @Inject constructor() : PokemonDetailsRouter() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        routers: Routers,
        backStackEntry: NavBackStackEntry,
    ) {
        PokemonDetailsScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
