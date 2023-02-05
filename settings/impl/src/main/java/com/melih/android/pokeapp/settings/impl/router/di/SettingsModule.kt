package com.melih.android.pokeapp.settings.impl.router.di

import com.melih.android.pokeapp.core.navigation.NavigationRouter
import com.melih.android.pokeapp.core.navigation.di.ScreenRouterKey
import com.melih.android.pokeapp.settings.api.router.SettingsRouter
import com.melih.android.pokeapp.settings.impl.router.DefaultSettingsRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class SettingsModule {

    @ActivityRetainedScoped
    @IntoMap
    @Binds
    @ScreenRouterKey(SettingsRouter::class)
    abstract fun bindSettingsRouter(router: DefaultSettingsRouter): NavigationRouter
}
