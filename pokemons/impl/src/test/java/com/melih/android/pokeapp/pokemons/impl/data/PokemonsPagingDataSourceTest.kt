package com.melih.android.pokeapp.pokemons.impl.data

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult
import androidx.paging.PagingState
import com.melih.android.pokeapp.core.coroutines.test.TestDispatcherExtension
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PAGE_SIZE
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PokemonService
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PokemonsPagingDataSource
import com.melih.android.pokeapp.pokemons.impl.data.datasource.START_OFFSET
import com.melih.android.pokeapp.pokemons.impl.data.mapper.mapToDomainModel
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonsResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import nl.wykorijnsburger.kminrandom.minRandomCached
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.IOException
import java.util.stream.Stream
import kotlin.math.min
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExtendWith(TestDispatcherExtension::class)
internal class PokemonsPagingDataSourceTest {

    private val service = mockk<PokemonService>()
    private val pagingSource = PokemonsPagingDataSource(service)

    @Nested
    inner class LoadTest {

        @Test
        fun `when loading the first page, offset starts from zero`() = runTest {
            val pokemonsResponse = createPokemonsResponse()
            coEvery { service.getPokemons(any(), any()) } returns pokemonsResponse

            pagingSource.load(createParams(null))

            coVerify { service.getPokemons(0, PAGE_SIZE) }
        }

        @Test
        fun `when loading the first page, load result contains the correct page`() =
            runTest {
                val params = createParams(key = null)
                val pokemonsResponse = createPokemonsResponse(
                    responseSize = 10,
                    totalCount = 50,
                    prevKey = null,
                )
                coEvery { service.getPokemons(any(), any()) } returns pokemonsResponse

                val expected = LoadResult.Page(
                    data = pokemonsResponse.mapToDomainModel(),
                    prevKey = null,
                    nextKey = 10,
                    itemsBefore = 0,
                    itemsAfter = 40,
                )

                val actualLoadResult = pagingSource.load(params)

                assertEquals(expected, actualLoadResult)
            }

        @Test
        fun `when loading the last page, then load result contains the correct page`() =
            runTest {
                val params = createParams(key = 40)
                val pokemonsResponse = createPokemonsResponse(
                    responseSize = 4,
                    totalCount = 44,
                    prevKey = createLoadKey(offset = 30),
                    nextKey = null,
                )
                coEvery { service.getPokemons(any(), any()) } returns pokemonsResponse

                val expected = LoadResult.Page(
                    data = pokemonsResponse.mapToDomainModel(),
                    prevKey = 30,
                    nextKey = null,
                    itemsBefore = 40,
                    itemsAfter = 0,
                )

                val actualLoadResult = pagingSource.load(params)

                assertEquals(expected, actualLoadResult)
                assertTrue(expected.data.size == 4)
            }

        @Test
        fun `when loading a middle page, then load result contains the correct page`() =
            runTest {
                val params = createParams(key = 20)
                val pokemonsResponse = createPokemonsResponse(
                    responseSize = 10,
                    totalCount = 50,
                    prevKey = createLoadKey(10),
                    nextKey = createLoadKey(30),
                )
                coEvery { service.getPokemons(any(), any()) } returns pokemonsResponse

                val expected = LoadResult.Page(
                    data = pokemonsResponse.mapToDomainModel(),
                    prevKey = 10,
                    nextKey = 30,
                    itemsBefore = 20,
                    itemsAfter = 20,
                )

                val actualLoadResult = pagingSource.load(params)

                assertEquals(expected, actualLoadResult)
                assertTrue(expected.data.size == 10)
            }

        @Test
        fun `when loading a page and response is empty, then load result contains the correct page`() =
            runTest {
                val params = createParams(key = 20)
                val pokemonsResponse = createPokemonsResponse(
                    responseSize = 0,
                    totalCount = 20,
                    prevKey = createLoadKey(10),
                    nextKey = null,
                )
                coEvery { service.getPokemons(any(), any()) } returns pokemonsResponse

                val expected = LoadResult.Page(
                    data = pokemonsResponse.mapToDomainModel(),
                    prevKey = 10,
                    nextKey = null,
                    itemsBefore = 20,
                    itemsAfter = 0,
                )

                val actualLoadResult = pagingSource.load(params)

                assertEquals(expected, actualLoadResult)
                assertTrue(expected.data.isEmpty())
            }

        @Test
        fun `and service throws an exception, then load result contains the error`() = runTest {
            val exception = IOException()
            coEvery { service.getPokemons(any(), any()) } throws exception

            val expected = LoadResult.Error<Int, Pokemon>(exception)

            val actualLoadResult = pagingSource.load(createParams(10))

            assertEquals(expected, actualLoadResult)
        }
    }

    @Nested
    inner class RefreshKeyTest {

        @ParameterizedTest
        @MethodSource("com.melih.android.pokeapp.pokemons.impl.data.PokemonsPagingDataSourceTest#getRefreshKeyTestingParams")
        fun `when getting the refresh key with given params, paging source returns correct refresh key`(
            anchorPosition: Int?,
            pages: List<LoadResult.Page<Int, Pokemon>>,
            expectedRefreshKey: Int?,
        ) {
            val state = createPagingState(anchorPosition = anchorPosition, pages = pages)

            val actualRefreshKey = pagingSource.getRefreshKey(state)

            assertEquals(expected = expectedRefreshKey, actual = actualRefreshKey)
        }
    }

    companion object {

        @JvmStatic
        fun getRefreshKeyTestingParams(): Stream<Arguments> = Stream.of(
            // when anchor position is null and there is no page, then refresh key is at top
            getRefreshKeyArgs(
                anchorPosition = null,
                pages = emptyList(),
                expectedRefreshKey = null,
            ),
            // when anchor position is null and there are pages, then refresh key is at top
            getRefreshKeyArgs(
                anchorPosition = null,
                pages = loadResults,
                expectedRefreshKey = null,
            ),
            // when anchor position is zero and there is no page, then refresh key is at top
            getRefreshKeyArgs(
                anchorPosition = 0,
                pages = emptyList(),
                expectedRefreshKey = null,
            ),
            // when anchor position is zero and there are pages, then refresh key is at top
            getRefreshKeyArgs(
                anchorPosition = 0,
                pages = loadResults,
                expectedRefreshKey = 0,
            ),
            // when prev key is null, then refresh key is at the closest page of the next key
            getRefreshKeyArgs(
                anchorPosition = 6,
                pages = loadResults,
                expectedRefreshKey = 0,
            ),
            // refresh key is at the previous page of the closest recently accessed offset
            getRefreshKeyArgs(
                anchorPosition = 29,
                pages = loadResults,
                expectedRefreshKey = 20,
            ),
            // when anchor position is at the last page offset, then refresh key is at the same offset
            getRefreshKeyArgs(
                anchorPosition = 30,
                pages = loadResults,
                expectedRefreshKey = 30,
            ),
        )

        private fun getRefreshKeyArgs(
            anchorPosition: Int?,
            pages: List<LoadResult.Page<Int, Pokemon>>,
            expectedRefreshKey: Int?,
        ) = arguments(anchorPosition, pages, expectedRefreshKey)

        private fun createPagingState(
            pages: List<LoadResult.Page<Int, Pokemon>>,
            anchorPosition: Int?,
        ) = PagingState(
            pages = pages,
            anchorPosition = anchorPosition,
            config = PagingConfig(PAGE_SIZE),
            leadingPlaceholderCount = 0,
        )

        private fun createParams(key: Int?) = PagingSource.LoadParams.Refresh(
            key = key,
            loadSize = PAGE_SIZE,
            placeholdersEnabled = true,
        )

        private fun createLoadKey(offset: Int) =
            "https://pokeapi.co/api/v2/pokemon?offset=$offset&limit=10"

        private fun createPokemonsResponse(
            responseSize: Int = PAGE_SIZE,
            totalCount: Int = responseSize,
            prevKey: String? = createLoadKey(START_OFFSET),
            nextKey: String? = createLoadKey(PAGE_SIZE),
        ) = PokemonsResponse(
            count = totalCount,
            next = nextKey,
            previous = prevKey,
            results = (1..min(responseSize, totalCount)).map {
                minRandomCached()
            },
        )
    }
}
