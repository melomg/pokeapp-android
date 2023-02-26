package com.melih.android.pokeapp.pokemons.impl.data.mapper

import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.api.model.Pokemons
import com.melih.android.pokeapp.pokemons.impl.data.response.PokemonResponse
import com.melih.android.pokeapp.pokemons.impl.data.response.PokemonsResponse
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class PokemonDataMapperTest {

    @ParameterizedTest
    @MethodSource("getPokemons")
    fun `response is mapped correctly`(
        response: PokemonsResponse,
        expectedDomainModel: Pokemons,
    ) {
        assertEquals(
            expected = expectedDomainModel,
            actual = response.toDomainModel(),
        )
    }

    companion object {
        private val defaultPokemonsResponse = PokemonsResponse(
            count = 100,
            next = "10",
            previous = "10",
            results = listOf(
                PokemonResponse("name", "url"),
                PokemonResponse("name1", "url1"),
            ),
        )

        private val defaultPokemons = Pokemons(
            count = 100,
            next = "10",
            previous = "10",
            results = listOf(
                Pokemon("name", "url"),
                Pokemon("name1", "url1"),
            ),
        )

        @JvmStatic
        fun getPokemons(): Stream<Arguments> = Stream.of(
            arguments(defaultPokemonsResponse, defaultPokemons),
            arguments(
                defaultPokemonsResponse.copy(
                    next = null,
                    previous = null,
                    results = emptyList(),
                ),
                defaultPokemons.copy(
                    next = null,
                    previous = null,
                    results = emptyList(),
                ),
            ),
            arguments(
                defaultPokemonsResponse.copy(
                    next = "",
                    previous = "",
                ),
                defaultPokemons.copy(
                    next = "",
                    previous = "",
                ),
            ),
        )
    }
}
