package com.melih.android.pokeapp.pokemons.api.data

import com.melih.android.pokeapp.pokemons.api.model.Pokemons

interface PokemonsRepository {

    suspend fun getPokemons(limit: Int, offset: Int): Result<Pokemons>
}
