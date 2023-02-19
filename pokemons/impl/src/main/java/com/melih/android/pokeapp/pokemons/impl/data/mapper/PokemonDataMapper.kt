package com.melih.android.pokeapp.pokemons.impl.data.mapper

import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.api.model.Pokemons
import com.melih.android.pokeapp.pokemons.impl.data.response.PokemonResponse
import com.melih.android.pokeapp.pokemons.impl.data.response.PokemonsResponse

internal fun PokemonsResponse.toDomainModel(): Pokemons = Pokemons(
    count = count,
    next = next,
    previous = previous,
    results = results.map { it.toDomainModel() },
)

private fun PokemonResponse.toDomainModel(): Pokemon = Pokemon(
    name = name,
    url = url,
)
