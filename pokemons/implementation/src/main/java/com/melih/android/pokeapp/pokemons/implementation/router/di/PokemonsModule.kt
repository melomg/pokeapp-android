package com.melih.android.pokeapp.pokemons.implementation.router.di

import com.melih.android.pokeapp.core.navigation.NavigationRouter
import com.melih.android.pokeapp.core.navigation.di.ScreenRouterKey
import com.melih.android.pokeapp.pokemons.implementation.router.DefaultPokemonsRouter
import com.melih.android.pokeapp.pokemons.api.router.PokemonsRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class PokemonsModule {

    @ActivityRetainedScoped
    @IntoMap
    @Binds
    @ScreenRouterKey(PokemonsRouter::class)
    abstract fun bindFavouritesRouter(router: DefaultPokemonsRouter): NavigationRouter
}
