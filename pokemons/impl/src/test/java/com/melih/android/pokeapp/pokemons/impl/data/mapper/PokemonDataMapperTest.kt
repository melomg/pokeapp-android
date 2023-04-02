package com.melih.android.pokeapp.pokemons.impl.data.mapper

import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonResponse
import com.melih.android.pokeapp.pokemons.impl.data.model.PokemonsResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class PokemonDataMapperTest {

    @Test
    fun `pokemons response is mapped correctly`() {
        assertEquals(
            expected = pokemons,
            actual = pokemonsResponse.mapToDomainModel(),
        )
    }

    @ParameterizedTest
    @MethodSource("getOffsetTestingParams")
    fun `offset is parsed correctly`(
        url: String,
        expectedOffset: Int?,
    ) {
        assertEquals(
            expected = expectedOffset,
            actual = url.parseOffset(),
        )
    }

    companion object {
        private val pokemonsResponse = PokemonsResponse(
            count = 100,
            next = "https://pokeapi.co/api/v2/pokemon?offset=20&limit=10",
            previous = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=10",
            results = listOf(
                PokemonResponse("name", "url"),
                PokemonResponse("name1", "url1"),
            ),
        )

        private val pokemons = listOf(
            Pokemon("name", "url"),
            Pokemon("name1", "url1"),
        )

        @JvmStatic
        fun getOffsetTestingParams(): Stream<Arguments> = Stream.of(
            arguments(
                "https://pokeapi.co/api/v2/pokemon?offset=20&limit=10",
                20,
            ),
            // when there is no ampersand sign and limit comes afterwards
            arguments(
                "https://sth.com/pokemon?offset=12limit=10",
                null,
            ),
            // when there is no ampersand sign and no param afterwards
            arguments(
                "https://pokeapi.co/api/v2/pokemon?offset=10",
                10,
            ),
            // when limit comes first in params
            arguments(
                "https://pokeapi.co/api/v2/pokemon?limit=10&offset=20",
                20,
            ),
            // when there is only query parts in url
            arguments(
                "offset=20&limit=10",
                20,
            ),
            // when there is no offset in params
            arguments(
                "https://pokeapi.co/api/v2/pokemon?limit=10",
                null,
            ),
            // when empty string
            arguments(
                "",
                null,
            ),
        )
    }
}
