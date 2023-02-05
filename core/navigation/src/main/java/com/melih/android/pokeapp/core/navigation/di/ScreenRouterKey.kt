package com.melih.android.pokeapp.core.navigation.di

import com.melih.android.pokeapp.core.navigation.NavigationRouter
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ScreenRouterKey(val value: KClass<out NavigationRouter>)
