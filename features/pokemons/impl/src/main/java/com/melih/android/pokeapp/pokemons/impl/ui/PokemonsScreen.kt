package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.melih.android.pokeapp.pokemons.api.model.Pokemon

@Composable
internal fun PokemonsScreen(
    onNavigateToPokemonDetail: (Pokemon) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonsViewModel = hiltViewModel(),
) {
    val pokemons = viewModel.paging.collectAsLazyPagingItems()

    when (val refreshState = pokemons.loadState.refresh) {
        is LoadState.Error -> PokemonsErrorState(refreshState.error.message)
        is LoadState.Loading -> LoadingRow(modifier.padding(top = 24.dp))
        is LoadState.NotLoading -> PokemonsSuccessState(pokemons, viewModel::onPokemonClicked)
    }

    val event by viewModel.event.collectAsStateWithLifecycle()

    event.navigateToPokemonDetail?.let {
        val currentOnNavigateToPokemonDetail by rememberUpdatedState(onNavigateToPokemonDetail)
        LaunchedEffect(event) {
            currentOnNavigateToPokemonDetail(it.pokemon)
            viewModel.eventHandled()
        }
    }
}
