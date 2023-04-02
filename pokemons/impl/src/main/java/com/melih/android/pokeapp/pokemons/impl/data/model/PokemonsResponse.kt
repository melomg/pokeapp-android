package com.melih.android.pokeapp.pokemons.impl.data.model

import com.melih.android.pokeapp.core.network.SerializedClass

@SerializedClass
data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResponse>,
)

@SerializedClass
data class PokemonResponse(
    val name: String,
    val url: String,
)
