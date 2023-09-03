package com.melih.android.pokeapp.pokemondetails.api.router

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.melih.android.pokeapp.core.navigation.ComposableRouter

abstract class PokemonDetailsRouter : ComposableRouter {

    final override val routeName = "$ROUTE_POKEMON_DETAILS/{$ARG_POKEMON_DETAILS_NAME}"

    final override val arguments: List<NamedNavArgument> =
        listOf(navArgument(ARG_POKEMON_DETAILS_NAME) { defaultValue = "" })

    companion object {
        const val ARG_POKEMON_DETAILS_NAME = "argPokemonName"
        private const val ROUTE_POKEMON_DETAILS = "pokemonDetails/{pokemonName}"

        fun NavHostController.navigateToPokemonDetails(pokemonName: String) =
            navigate("$ROUTE_POKEMON_DETAILS/$pokemonName")
    }
}
