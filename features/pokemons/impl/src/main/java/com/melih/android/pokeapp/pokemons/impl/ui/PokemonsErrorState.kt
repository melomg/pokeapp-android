package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.melih.android.pokeapp.core.designsystem.compose.DevicePreviews
import com.melih.android.pokeapp.core.designsystem.theme.PokeAppTheme
import com.melih.android.pokeapp.core.l10n.R

@Composable
internal fun PokemonsErrorState(errorMessage: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = errorMessage ?: stringResource(R.string.generic_error),
            textAlign = TextAlign.Center,
        )
    }
}

@DevicePreviews
@Composable
private fun ErrorStatePreview() {
    PokeAppTheme {
        PokemonsErrorState("Generic error occurred!")
    }
}
