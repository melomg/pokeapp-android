package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.melih.android.pokeapp.pokemons.impl.ui.PokemonsState.Error
import com.melih.android.pokeapp.pokemons.impl.ui.PokemonsState.Initial
import com.melih.android.pokeapp.pokemons.impl.ui.PokemonsState.Success

@Composable
internal fun PokemonsScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        when (state) {
            is Initial -> Text(text = "Pokemons Initial")
            is Error -> Text(text = "Pokemons Error")
            is Success -> Text(text = "Pokemons Success")
        }
    }
}
