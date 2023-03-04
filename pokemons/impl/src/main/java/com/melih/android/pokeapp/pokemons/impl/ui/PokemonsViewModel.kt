package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.api.model.Pokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class PokemonsViewModel @Inject constructor(
    repository: PokemonsRepository,
) : ViewModel() {

    val state: StateFlow<PokemonsState>
        get() = _state

    private val _state = MutableStateFlow<PokemonsState>(PokemonsState.Initial)

    init {
        viewModelScope.launch {
            repository.getPokemons(0, 0) // todo implement pagination later
                .toUIState()
                .let { newState ->
                    _state.value = newState
                }
        }
    }
}

private fun Result<Pokemons>.toUIState(): PokemonsState = fold(
    onSuccess = { PokemonsState.Success },
    onFailure = { PokemonsState.Error(it) },
)
