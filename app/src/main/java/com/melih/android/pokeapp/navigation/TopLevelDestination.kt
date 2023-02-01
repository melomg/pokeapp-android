package com.melih.android.pokeapp.navigation

import com.melih.android.pokeapp.core.designsystem.icon.Icon
import com.melih.android.pokeapp.core.designsystem.icon.Icon.DrawableResourceIcon
import com.melih.android.pokeapp.core.designsystem.icon.Icon.ImageVectorIcon
import com.melih.android.pokeapp.core.designsystem.icon.PokeIcons

internal enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
) {
    POKEMONS(
        selectedIcon = DrawableResourceIcon(PokeIcons.PokeBall),
        unselectedIcon = DrawableResourceIcon(PokeIcons.PokeBall),
    ),
    FAVOURITES(
        selectedIcon = DrawableResourceIcon(PokeIcons.Favourite),
        unselectedIcon = DrawableResourceIcon(PokeIcons.FavouriteBorder),
    ),
    SETTINGS(
        selectedIcon = ImageVectorIcon(PokeIcons.Settings),
        unselectedIcon = ImageVectorIcon(PokeIcons.Settings),
    )
}
