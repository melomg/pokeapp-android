package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.ui.PokemonsEvent.Companion.NoEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class PokemonsViewModel @Inject constructor(
    repository: PokemonsRepository,
) : ViewModel() {

    val paging: Flow<PagingData<Pokemon>> = repository
        .getPokemons()
        .cachedIn(viewModelScope)

    val event: StateFlow<PokemonsEvent>
        get() = _event

    private val _event = MutableStateFlow(NoEvent)

    fun onPokemonClicked(pokemon: Pokemon) {
        _event.update { it.copy(navigateToPokemonDetail = NavigateToPokemonDetail(pokemon)) }
    }

    fun eventHandled() {
        _event.update { it.copy(navigateToPokemonDetail = null) }
    }
}
