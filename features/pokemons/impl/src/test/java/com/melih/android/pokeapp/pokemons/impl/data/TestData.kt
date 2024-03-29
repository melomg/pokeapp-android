package com.melih.android.pokeapp.pokemons.impl.data

import androidx.paging.PagingSource
import com.melih.android.pokeapp.pokemons.api.model.Pokemon
import nl.wykorijnsburger.kminrandom.minRandomCached

val allPokemons = (1..36).map {
    minRandomCached<Pokemon>().copy(
        name = it.toString(),
    )
}

val loadResults = listOf(
    PagingSource.LoadResult.Page(
        data = allPokemons.subList(0, 10),
        prevKey = null,
        nextKey = 10,
        itemsBefore = 0,
        itemsAfter = 25,
    ),
    PagingSource.LoadResult.Page(
        data = allPokemons.subList(10, 20),
        prevKey = 0,
        nextKey = 20,
        itemsBefore = 10,
        itemsAfter = 15,
    ),
    PagingSource.LoadResult.Page(
        data = allPokemons.subList(20, 30),
        prevKey = 10,
        nextKey = 30,
        itemsBefore = 20,
        itemsAfter = 6,
    ),
    PagingSource.LoadResult.Page(
        data = allPokemons.subList(30, 36),
        prevKey = 20,
        nextKey = null,
        itemsBefore = 30,
        itemsAfter = 0,
    ),
)
