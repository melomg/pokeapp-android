package com.melih.android.pokeapp.pokemons.impl.data

import com.melih.android.pokeapp.core.coroutines.DispatcherProvider
import com.melih.android.pokeapp.core.result.ext.alsoLogError
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.api.model.Pokemons
import com.melih.android.pokeapp.pokemons.impl.data.mapper.toDomainModel
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonsRepository @Inject constructor(
    private val service: PokemonService,
) : PokemonsRepository {

    override suspend fun getPokemons(
        limit: Int,
        offset: Int,
    ): Result<Pokemons> = withContext(DispatcherProvider.IO) {
        return@withContext runCatching {
            service
                .getPokemons(limit = limit, offset = offset)
                .toDomainModel()
        }.alsoLogError()
    }
}
