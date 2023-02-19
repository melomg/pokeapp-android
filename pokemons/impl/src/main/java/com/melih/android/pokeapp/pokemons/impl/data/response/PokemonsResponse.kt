package com.melih.android.pokeapp.pokemons.impl.data.response

data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResponse>,
)

data class PokemonResponse(
    val name: String,
    val url: String,
)
