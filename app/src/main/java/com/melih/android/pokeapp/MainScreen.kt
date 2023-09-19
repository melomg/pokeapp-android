package com.melih.android.pokeapp

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.core.navigation.find
import com.melih.android.pokeapp.navigation.PokeBottomBar
import com.melih.android.pokeapp.navigation.PokeNavHost
import com.melih.android.pokeapp.pokemons.api.router.PokemonsNestedRouter

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun MainScreen(
    routers: Routers,
    modifier: Modifier = Modifier,
) {
    val appState: PokeAppState = rememberPokeAppState(routers)

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize(),
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            bottomBar = {
                PokeBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                )
            },
        ) { padding ->
            PokeNavHost(
                navController = appState.navController,
                routers = routers,
                startDestination = routers.find<PokemonsNestedRouter>().routeName,
                modifier = Modifier
                    .padding(padding)
                    .consumedWindowInsets(padding),
            )
        }
    }
}
