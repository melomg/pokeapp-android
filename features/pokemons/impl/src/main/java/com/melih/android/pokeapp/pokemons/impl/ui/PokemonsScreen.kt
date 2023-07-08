package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
internal fun PokemonsScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonsViewModel = hiltViewModel(),
) {
    val pokemons = viewModel.paging.collectAsLazyPagingItems()

    when (val refreshState = pokemons.loadState.refresh) {
        is LoadState.Error -> PokemonsErrorState(refreshState.error.message)
        is LoadState.Loading -> LoadingRow(modifier.padding(top = 24.dp))
        is LoadState.NotLoading -> PokemonsSuccessState(pokemons)
    }
}
