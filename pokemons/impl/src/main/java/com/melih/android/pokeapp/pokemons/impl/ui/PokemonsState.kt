package com.melih.android.pokeapp.pokemons.impl.ui

internal sealed interface PokemonsState {

    object Initial : PokemonsState

    data class Error(val exception: Throwable) : PokemonsState

    object Success : PokemonsState
}
