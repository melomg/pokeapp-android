package com.melih.android.pokeapp.pokemons.implementation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.pokemonsDestination(route: String) {
    composable(route = route) {
        PokemonsScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
