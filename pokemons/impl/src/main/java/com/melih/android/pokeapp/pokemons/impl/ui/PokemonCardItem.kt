package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.melih.android.pokeapp.pokemons.api.model.Pokemon

@Composable
internal fun PokemonCardItem(pokemon: Pokemon) {
    Box(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterStart),
            text = pokemon.name,
            textAlign = TextAlign.Center,
        )
    }
}
