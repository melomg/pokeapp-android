package com.melih.android.pokeapp.pokemons.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.melih.android.pokeapp.pokemons.implementation.pokemonsDestination

const val pokemonsRoute = "pokemons_route"

fun NavController.navigateToPokemons(navOptions: NavOptions? = null) {
    this.navigate(pokemonsRoute, navOptions)
}

fun NavGraphBuilder.createPokemonsDestination() = pokemonsDestination(pokemonsRoute)
