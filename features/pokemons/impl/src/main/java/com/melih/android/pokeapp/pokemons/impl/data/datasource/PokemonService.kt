package com.melih.android.pokeapp.pokemons.impl.data.datasource

import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonsResponse
}
