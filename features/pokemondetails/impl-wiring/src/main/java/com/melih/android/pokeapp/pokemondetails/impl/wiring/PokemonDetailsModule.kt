package com.melih.android.pokeapp.pokemondetails.impl.wiring

import com.melih.android.pokeapp.core.navigation.NavigationRouter
import com.melih.android.pokeapp.core.navigation.di.ScreenRouterKey
import com.melih.android.pokeapp.pokemondetails.api.router.PokemonDetailsRouter
import com.melih.android.pokeapp.pokemondetails.impl.router.DefaultPokemonDetailsRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class PokemonDetailsModule {

    @ActivityRetainedScoped
    @IntoMap
    @Binds
    @ScreenRouterKey(PokemonDetailsRouter::class)
    abstract fun bindPokemonDetailsRouter(router: DefaultPokemonDetailsRouter): NavigationRouter
}
