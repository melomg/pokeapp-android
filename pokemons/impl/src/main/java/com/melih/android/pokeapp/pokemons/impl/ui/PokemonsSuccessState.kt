package com.melih.android.pokeapp.pokemons.impl.ui

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.melih.android.pokeapp.pokemons.api.model.Pokemon

@Composable
fun PokemonsSuccessState(pokemons: LazyPagingItems<Pokemon>) {
    val appendState = pokemons.loadState.append
    val context = LocalContext.current

    LazyColumn {
        items(
            items = pokemons,
            key = { it.url },
        ) { pokemon ->
            pokemon?.let {
                PokemonCardItem(it)
                Divider()
            }
        }

        when (appendState) { // Pagination
            is LoadState.Error -> {
                Toast
                    .makeText(context, appendState.error.message ?: "", Toast.LENGTH_SHORT)
                    .show()
            }
            is LoadState.Loading -> { // Pagination Loading UI
                item { LoadingRow() }
            }
            else -> {
                // no-op handled inside refresh state
            }
        }
    }
}
