package com.melih.android.pokeapp.pokemons.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.melih.android.pokeapp.core.designsystem.compose.DevicePreviews
import com.melih.android.pokeapp.core.designsystem.theme.PokeAppTheme

@Composable
internal fun LoadingRow(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        CircularProgressIndicator()
    }
}

@DevicePreviews
@Composable
private fun LoadingRowPreview() {
    PokeAppTheme {
        LoadingRow()
    }
}
