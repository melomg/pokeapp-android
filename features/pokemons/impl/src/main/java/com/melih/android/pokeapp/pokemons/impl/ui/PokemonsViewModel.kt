package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
internal class PokemonsViewModel @Inject constructor(
    repository: PokemonsRepository,
) : ViewModel() {

    val paging: Flow<PagingData<Pokemon>> = repository
        .getPokemons()
        .cachedIn(viewModelScope)
}
