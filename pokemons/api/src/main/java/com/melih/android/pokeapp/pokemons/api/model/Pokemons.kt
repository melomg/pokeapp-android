package com.melih.android.pokeapp.pokemons.api.model

data class Pokemons(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>,
)

data class Pokemon(
    val name: String,
    val url: String,
)
