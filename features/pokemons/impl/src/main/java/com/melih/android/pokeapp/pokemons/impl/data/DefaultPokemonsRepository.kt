package com.melih.android.pokeapp.pokemons.impl.data

import androidx.paging.PagingData
import com.melih.android.pokeapp.core.coroutines.DispatcherProvider
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PokemonsPagerFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonsRepository @Inject constructor(
    private val pagerFactory: PokemonsPagerFactory,
) : PokemonsRepository {

    override fun getPokemons(): Flow<PagingData<Pokemon>> =
        pagerFactory.create()
            .flowOn(DispatcherProvider.IO)
}
