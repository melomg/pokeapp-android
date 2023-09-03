package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.melih.android.pokeapp.pokemons.api.model.Pokemon

@Suppress("UNUSED_PARAMETER")
@Composable
internal fun PokemonsScreen(
    onNavigateToPokemonDetail: (Pokemon) -> Unit, // TODO: Use this with event flow
    modifier: Modifier = Modifier,
    viewModel: PokemonsViewModel = hiltViewModel(),
) {
    val pokemons = viewModel.paging.collectAsLazyPagingItems()

    when (val refreshState = pokemons.loadState.refresh) {
        is LoadState.Error -> PokemonsErrorState(refreshState.error.message)
        is LoadState.Loading -> LoadingRow(modifier.padding(top = 24.dp))
        is LoadState.NotLoading -> PokemonsSuccessState(pokemons, viewModel::onPokemonClicked)
    }
}
