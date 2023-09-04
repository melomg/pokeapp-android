package com.melih.android.pokeapp.pokemons.impl.ui

import com.melih.android.pokeapp.pokemons.api.model.Pokemon

data class PokemonsEvent(
    val navigateToPokemonDetail: NavigateToPokemonDetail? = null,
) {

    companion object {
        val NoEvent = PokemonsEvent()
    }
}

data class NavigateToPokemonDetail(val pokemon: Pokemon)
