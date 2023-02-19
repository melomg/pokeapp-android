package com.melih.android.pokeapp.pokemons.impl.data

import com.melih.android.pokeapp.pokemons.impl.data.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonsResponse
}
