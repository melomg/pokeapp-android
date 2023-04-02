package com.melih.android.pokeapp.pokemons.impl.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melih.android.pokeapp.core.coroutines.DispatcherProvider
import com.melih.android.pokeapp.core.result.ext.alsoLogError
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.data.mapper.mapToDomainModel
import com.melih.android.pokeapp.pokemons.impl.data.mapper.parseOffset
import dagger.Reusable
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min

@Reusable
class PokemonsPagingDataSource @Inject constructor(
    private val service: PokemonService,
) : PagingSource<Int, Pokemon>() {

    private val LoadParams<Int>.offset: Int
        get() = key ?: START_OFFSET

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> =
        withContext(DispatcherProvider.IO) {
            runCatching {
                service.getPokemons(offset = params.offset, limit = params.loadSize)
            }
                .alsoLogError()
                .fold(
                    onSuccess = {
                        LoadResult.Page(
                            data = it.mapToDomainModel(),
                            prevKey = it.previous?.parseOffset(),
                            nextKey = it.next?.parseOffset(),
                            itemsBefore = getItemsBefore(
                                totalCount = it.count,
                                offset = params.offset,
                            ),
                            itemsAfter = getItemsAfter(
                                totalCount = it.count,
                                responseSize = it.results.size,
                                offset = params.offset,
                            ),
                        )
                    },
                    onFailure = { LoadResult.Error(it) },
                )
        }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed offset
        // Anchor position is the most recently accessed offset
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(PAGE_SIZE)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(PAGE_SIZE)
        }
    }

    private fun getItemsBefore(totalCount: Int, offset: Int) = min(offset, totalCount)

    private fun getItemsAfter(
        totalCount: Int,
        responseSize: Int,
        offset: Int,
    ) = max(0, totalCount - (offset + responseSize))
}
