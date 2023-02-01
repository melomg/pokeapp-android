package com.melih.android.pokeapp.favourites.implementation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.favouritesDestination(route: String) {
    composable(route = route) {
        FavouritesScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
