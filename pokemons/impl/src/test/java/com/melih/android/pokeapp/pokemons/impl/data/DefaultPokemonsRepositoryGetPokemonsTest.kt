package com.melih.android.pokeapp.pokemons.impl.data

import com.melih.android.pokeapp.core.coroutines.test.TestDispatcherExtension
import com.melih.android.pokeapp.pokemons.impl.data.mapper.toDomainModel
import com.melih.android.pokeapp.pokemons.impl.data.response.PokemonsResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import nl.wykorijnsburger.kminrandom.minRandomCached
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.io.IOException
import kotlin.test.assertEquals

@ExtendWith(TestDispatcherExtension::class)
internal class DefaultPokemonsRepositoryGetPokemonsTest {

    private val service = mockk<PokemonService>()
    private val repository = DefaultPokemonsRepository(service)

    @Nested
    @DisplayName("when the service returns successfully,")
    inner class SuccessFlow {

        @Test
        fun `then success result is returned`() {
            runTest {
                coEvery { service.getPokemons(any(), any()) } returns FAKE_POKEMONS

                val result = repository.getPokemons(0, 0)

                assertEquals(
                    expected = Result.success(FAKE_POKEMONS.toDomainModel()),
                    actual = result,
                )
            }
        }
    }

    @Nested
    inner class ErrorFlow {

        @Test
        fun `given service throws error when getting pokemons, then error result is returned`() {
            runTest {
                val exception = IOException("Network error!")
                coEvery { service.getPokemons(any(), any()) } throws exception

                val result = repository.getPokemons(0, 0)

                assertEquals(
                    expected = Result.failure(exception),
                    actual = result,
                )
            }
        }
    }

    companion object {
        private val FAKE_POKEMONS = minRandomCached<PokemonsResponse>()
    }
}
