package com.melih.android.pokeapp.favourites.impl.router.di

import com.melih.android.pokeapp.core.navigation.NavigationRouter
import com.melih.android.pokeapp.core.navigation.di.ScreenRouterKey
import com.melih.android.pokeapp.favourites.api.router.FavouritesRouter
import com.melih.android.pokeapp.favourites.impl.router.DefaultFavouritesRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class FavouritesModule {

    @ActivityRetainedScoped
    @IntoMap
    @Binds
    @ScreenRouterKey(FavouritesRouter::class)
    abstract fun bindFavouritesRouter(router: DefaultFavouritesRouter): NavigationRouter
}
