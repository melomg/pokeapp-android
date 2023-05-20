package com.melih.android.pokeapp.pokemons.impl.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.R

@Composable
fun PokemonsSuccessState(pokemons: LazyPagingItems<Pokemon>) {
    val appendState = pokemons.loadState.append
    val context = LocalContext.current

    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Adaptive(minSize = dimensionResource(R.dimen.pokemon_image_size)),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            count = pokemons.itemCount,
        ) { index ->
            pokemons[index]?.let { pokemon ->
                PokemonCardItem(pokemon)
            }
        }

        when (appendState) { // Pagination
            is LoadState.Error -> {
                Toast
                    .makeText(context, appendState.error.message ?: "", Toast.LENGTH_SHORT)
                    .show()
            }
            is LoadState.Loading -> { // Pagination Loading UI
                item(span = { GridItemSpan(maxLineSpan) }) {
                    LoadingRow()
                }
            }
            else -> {
                // no-op handled inside refresh state
            }
        }
    }
}
