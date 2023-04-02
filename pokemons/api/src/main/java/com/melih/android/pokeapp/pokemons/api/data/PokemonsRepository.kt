package com.melih.android.pokeapp.pokemons.api.data

import androidx.paging.PagingData
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {

    fun getPokemons(): Flow<PagingData<Pokemon>>
}
