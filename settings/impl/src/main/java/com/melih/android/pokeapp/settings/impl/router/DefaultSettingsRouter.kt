package com.melih.android.pokeapp.settings.impl.router

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.melih.android.pokeapp.core.navigation.Routers
import com.melih.android.pokeapp.settings.api.router.SettingsRouter
import com.melih.android.pokeapp.settings.impl.ui.SettingsScreen
import javax.inject.Inject

class DefaultSettingsRouter @Inject constructor() : SettingsRouter() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        routers: Routers,
        backStackEntry: NavBackStackEntry
    ) {
        SettingsScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
