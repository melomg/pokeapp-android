package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.melih.android.pokeapp.core.designsystem.compose.DevicePreviews
import com.melih.android.pokeapp.core.designsystem.theme.PokeAppTheme
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import com.melih.android.pokeapp.pokemons.impl.R

@Composable
internal fun PokemonCardItem(
    pokemon: Pokemon,
    onPokemonClicked: (Pokemon) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .width(dimensionResource(R.dimen.pokemon_image_size))
            .clickable { onPokemonClicked(pokemon) },
    ) {
        AsyncImage(
            model = pokemon.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background),
        )

        Text(
            text = pokemon.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .shadow(elevation = 1.dp, spotColor = MaterialTheme.colorScheme.onBackground)
                .fillMaxWidth()
                .padding(12.dp),
        )
    }
}

@DevicePreviews
@Composable
private fun PokemonCardItemPreview() {
    PokeAppTheme {
        PokemonCardItem(
            pokemon = Pokemon(
                name = "Pikachu",
                imageUrl = "imageUrl",
            ),
            onPokemonClicked = {},
        )
    }
}
