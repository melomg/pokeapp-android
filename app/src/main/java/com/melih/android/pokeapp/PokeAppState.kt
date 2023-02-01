package com.melih.android.pokeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.melih.android.pokeapp.favourites.api.navigateToFavourites
import com.melih.android.pokeapp.navigation.TopLevelDestination
import com.melih.android.pokeapp.navigation.TopLevelDestination.FAVOURITES
import com.melih.android.pokeapp.navigation.TopLevelDestination.POKEMONS
import com.melih.android.pokeapp.navigation.TopLevelDestination.SETTINGS
import com.melih.android.pokeapp.pokemons.api.navigateToPokemons
import com.melih.android.pokeapp.settings.api.router.navigateToSettings

@Composable
internal fun rememberPokeAppState(
    navController: NavHostController = rememberNavController()
): PokeAppState = remember(navController) {
    PokeAppState(navController)
}

@Stable
internal class PokeAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            POKEMONS -> {
                navController.navigateToPokemons(topLevelNavOptions)
            }
            FAVOURITES -> {
                navController.navigateToFavourites(topLevelNavOptions)
            }
            SETTINGS -> {
                navController.navigateToSettings(topLevelNavOptions)
            }
        }
    }
}
