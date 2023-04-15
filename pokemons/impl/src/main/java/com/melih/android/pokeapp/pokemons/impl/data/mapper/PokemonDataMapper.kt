package com.melih.android.pokeapp.pokemons.impl.data.mapper

import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonResponse
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonsResponse

internal fun PokemonsResponse.mapToDomainModel(): List<Pokemon> =
    results.map { it.mapToDomainModel() }

private fun PokemonResponse.mapToDomainModel(): Pokemon = Pokemon(
    name = name,
    url = url,
)

// Uri example: https://pokeapi.co/api/v2/pokemon?offset=10&limit=10
internal fun String.parseOffset(): Int? = substringAfter("offset=")
    .substringBefore("&")
    .toIntOrNull()
