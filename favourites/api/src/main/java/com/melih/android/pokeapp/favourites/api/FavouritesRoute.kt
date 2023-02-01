package com.melih.android.pokeapp.favourites.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.melih.android.pokeapp.favourites.implementation.favouritesDestination

const val favouritesRoute = "favourites_route"

fun NavController.navigateToFavourites(navOptions: NavOptions? = null) {
    this.navigate(favouritesRoute, navOptions)
}

fun NavGraphBuilder.createFavouritesDestination() = favouritesDestination(favouritesRoute)
