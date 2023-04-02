package com.melih.android.pokeapp.pokemons.impl.data

import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import com.melih.android.pokeapp.core.coroutines.test.TestDispatcherExtension
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PokemonsPagerFactory
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.io.IOException
import kotlin.test.assertEquals

@ExtendWith(TestDispatcherExtension::class)
internal class DefaultPokemonsRepositoryTest {

    private val pagerFactory = mockk<PokemonsPagerFactory>()
    private val repository = DefaultPokemonsRepository(pagerFactory = pagerFactory)

    private val pagingDataFlow = MutableStateFlow(PagingData.from(allPokemons.subList(0, 10)))

    @BeforeEach
    fun beforeEach() = runTest {
        every { pagerFactory.create() } returns pagingDataFlow
    }

    @Nested
    @DisplayName("when the service returns successfully,")
    inner class GetPokemonsSuccessFlow {

        @Test
        fun `then success result is returned`() = runTest {
            pagingDataFlow.value = PagingData.from(
                allPokemons.subList(0, 10),
                sourceLoadStates = LoadStates(
                    refresh = LoadState.NotLoading(endOfPaginationReached = false),
                    prepend = LoadState.NotLoading(endOfPaginationReached = false),
                    append = LoadState.NotLoading(endOfPaginationReached = false),
                ),
            )

            val items = repository.getPokemons().testPaging(this)

            assertEquals(
                expected = items,
                actual = allPokemons.subList(0, 10),
            )
        }
    }

    @Nested
    inner class GetPokemonsErrorFlow {

        @Test
        fun `given service throws error when getting pokemons, then error result is returned`() {
            runTest {
                val ioException = IOException()
                pagingDataFlow.value = PagingData.from(
                    allPokemons.subList(0, 10),
                    sourceLoadStates = LoadStates(
                        refresh = LoadState.Error(ioException),
                        prepend = LoadState.Error(ioException),
                        append = LoadState.Error(ioException),
                    ),
                )

                assertThrows<IOException> {
                    repository.getPokemons().testPaging(this)
                }
            }
        }
    }
}
