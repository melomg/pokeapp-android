package com.melih.android.pokeapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

typealias Routers = Map<Class<out NavigationRouter>, @JvmSuppressWildcards NavigationRouter>

interface NavigationRouter {

    val routeName: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}

interface ComposableRouter : NavigationRouter {

    fun NavGraphBuilder.composable(navController: NavHostController, routers: Routers) {
        composable(routeName, arguments, deepLinks) { backStackEntry ->
            Composable(navController, routers, backStackEntry)
        }
    }

    @Composable
    fun Composable(
        navController: NavHostController,
        routers: Routers,
        backStackEntry: NavBackStackEntry,
    )
}

@Suppress("unused")
interface NestedGraphRouter : NavigationRouter {

    fun NavGraphBuilder.navigation(navController: NavHostController, routers: Routers)
}

inline fun <reified T : NavigationRouter> Routers.find(): T =
    findOrNull() ?: error("Unable to find '${T::class.java}' destination.")

inline fun <reified T : NavigationRouter> Routers.findOrNull(): T? =
    this[T::class.java] as? T
