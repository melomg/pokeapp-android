package com.melih.android.pokeapp.pokemons.impl.ui

import com.melih.android.pokeapp.core.coroutines.test.TestDispatcherExtension
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.emptyFlow
import nl.wykorijnsburger.kminrandom.minRandomCached
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@ExtendWith(TestDispatcherExtension::class)
internal class PokemonsViewModelTest {

    private val repository = mockk<PokemonsRepository>()
    private lateinit var viewModel: PokemonsViewModel

    @BeforeEach
    fun beforeEach() {
        every { repository.getPokemons() } returns emptyFlow()
        viewModel = PokemonsViewModel(repository)
    }

    @Test
    fun `when a pokemon is clicked, then state is changed with event`() {
        val pokemon = minRandomCached<Pokemon>()

        assertNull(viewModel.event.value.navigateToPokemonDetail)

        viewModel.onPokemonClicked(pokemon)

        assertEquals(
            expected = NavigateToPokemonDetail(pokemon),
            actual = viewModel.event.value.navigateToPokemonDetail
        )
    }

    @Test
    fun `when a pokemon is clicked and event is handled, then state contains NO event`() {
        val pokemon = minRandomCached<Pokemon>()

        assertNull(viewModel.event.value.navigateToPokemonDetail)

        viewModel.onPokemonClicked(pokemon)

        assertNotNull(viewModel.event.value.navigateToPokemonDetail)

        viewModel.eventHandled()

        assertNull(viewModel.event.value.navigateToPokemonDetail)
    }

    @Test
    fun `when event is handled and then a new event comes, then state contains the event`() {
        viewModel.eventHandled()

        assertNull(viewModel.event.value.navigateToPokemonDetail)

        viewModel.onPokemonClicked(minRandomCached())

        assertNotNull(viewModel.event.value.navigateToPokemonDetail)
    }
}
