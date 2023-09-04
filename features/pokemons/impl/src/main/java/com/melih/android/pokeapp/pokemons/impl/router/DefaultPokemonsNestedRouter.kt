package com.melih.android.pokeapp.pokemons.impl.router

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.core.navigation.find
import com.melih.android.pokeapp.pokemondetails.api.router.PokemonDetailsRouter
import com.melih.android.pokeapp.pokemons.api.router.PokemonsNestedRouter
import com.melih.android.pokeapp.pokemons.api.router.PokemonsRouter
import javax.inject.Inject

class DefaultPokemonsNestedRouter @Inject constructor() : PokemonsNestedRouter() {

    override fun NavGraphBuilder.navigation(navController: NavHostController, routers: Routers) {
        navigation(startDestination = routers.find<PokemonsRouter>().routeName, route = routeName) {
            with(routers.find<PokemonsRouter>()) {
                composable(navController, routers)
            }
            with(routers.find<PokemonDetailsRouter>()) {
                composable(navController, routers)
            }
        }
    }
}
