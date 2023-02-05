package com.melih.android.pokeapp.pokemons.implementation.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.pokemons.api.router.PokemonsRouter
import com.melih.android.pokeapp.pokemons.implementation.PokemonsScreen
import javax.inject.Inject

internal class DefaultPokemonsRouter @Inject constructor() : PokemonsRouter() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        routers: Routers,
        backStackEntry: NavBackStackEntry
    ) {
        PokemonsScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
