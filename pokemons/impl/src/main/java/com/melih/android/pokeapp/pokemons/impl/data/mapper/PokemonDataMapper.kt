package com.melih.android.pokeapp.pokemons.impl.data.mapper

import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonResponse
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonsResponse

private const val POKE_IMAGE_BASE_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%s.png"

internal fun PokemonsResponse.mapToDomainModel(): List<Pokemon> =
    results.map { it.mapToDomainModel() }

private fun PokemonResponse.mapToDomainModel(): Pokemon = Pokemon(
    name = name,
    imageUrl = url
        .takeIf { it.endsWith("/") }
        ?.dropLast(1)
        ?.takeLastWhile { it.isDigit() }
        ?.let { pokemonNumber ->
            POKE_IMAGE_BASE_URL.format(pokemonNumber)
        }
        ?: "",
)

// Uri example: https://pokeapi.co/api/v2/pokemon?offset=10&limit=10
internal fun String.parseOffset(): Int? = substringAfter("offset=")
    .substringBefore("&")
    .toIntOrNull()
