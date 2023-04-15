package com.melih.android.pokeapp.pokemons.impl.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider

@Reusable
class PokemonsPagerFactory @Inject constructor(
    private val pagingConfig: PagingConfig,
    private val pagingDataSource: Provider<PokemonsPagingDataSource>,
) {

    fun create() = Pager(
        config = pagingConfig,
        pagingSourceFactory = { pagingDataSource.get() },
    ).flow
}
