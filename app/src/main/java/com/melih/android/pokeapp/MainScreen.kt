package com.melih.android.pokeapp

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.core.navigation.find
import com.melih.android.pokeapp.pokemons.api.router.PokemonsRouter
import com.melih.android.pokeapp.navigation.PokeBottomBar
import com.melih.android.pokeapp.navigation.PokeNavHost

@OptIn(
    ExperimentalLayoutApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
internal fun MainScreen(routers: Routers) {

    val appState: PokeAppState = rememberPokeAppState(routers)

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
    ) {

        Scaffold(
            containerColor = Color.Transparent,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            bottomBar = {
                PokeBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        ) { padding ->
            PokeNavHost(
                navController = appState.navController,
                routers = routers,
                startDestination = routers.find<PokemonsRouter>().routeName,
                modifier = Modifier
                    .padding(padding)
                    .consumedWindowInsets(padding)
            )
        }
    }
}
