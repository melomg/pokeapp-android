package com.melih.android.pokeapp.favourites.impl.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.favourites.api.router.FavouritesRouter
import com.melih.android.pokeapp.favourites.impl.ui.FavouritesScreen
import javax.inject.Inject

class DefaultFavouritesRouter @Inject constructor() : FavouritesRouter() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        routers: Routers,
        backStackEntry: NavBackStackEntry,
    ) {
        FavouritesScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
