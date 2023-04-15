package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
internal fun PokemonsScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonsViewModel = hiltViewModel(),
) {
    val pokemons = viewModel.paging.collectAsLazyPagingItems()

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        when (pokemons.loadState.refresh) {
            is LoadState.Error -> {
                Text(text = "Pokemons Error")
            }
            is LoadState.Loading -> {
                Text(text = "Pokemons Loading")
            }
            else -> {
                Text(text = "Pokemons Initial")
            }
        }
    }
}
