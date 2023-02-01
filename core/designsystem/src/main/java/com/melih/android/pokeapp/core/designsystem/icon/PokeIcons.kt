package com.melih.android.pokeapp.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.melih.android.pokeapp.core.designsystem.R

object PokeIcons {
    val ArrowBack = Icons.Rounded.ArrowBack
    val ArrowDropDown = Icons.Rounded.ArrowDropDown
    val ArrowDropUp = Icons.Rounded.ArrowDropUp
    val Close = Icons.Rounded.Close
    val Favourite = R.drawable.ic_favorite_24
    val FavouriteBorder = R.drawable.ic_favorite_border_24
    val MoreVert = Icons.Default.MoreVert
    val Person = Icons.Rounded.Person
    val PokeBall = R.drawable.ic_pokeball
    val Settings = Icons.Rounded.Settings
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
