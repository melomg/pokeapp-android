package com.melih.android.pokeapp.pokemons.impl.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.pokemondetails.api.router.PokemonDetailsRouter.Companion.navigateToPokemonDetails
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.api.router.PokemonsRouter
import com.melih.android.pokeapp.pokemons.impl.ui.PokemonsScreen
import javax.inject.Inject

class DefaultPokemonsRouter @Inject constructor() : PokemonsRouter() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        routers: Routers,
        backStackEntry: NavBackStackEntry,
    ) {
        PokemonsScreen(
            onNavigateToPokemonDetail = { pokemon: Pokemon ->
                navController.navigateToPokemonDetails(pokemon.name)
            },
            modifier = Modifier.fillMaxSize(),
        )
    }
}
