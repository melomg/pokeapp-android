package com.melih.android.impl.wiring

import androidx.paging.PagingConfig
import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.impl.data.DefaultPokemonsRepository
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PAGE_SIZE
import com.melih.android.pokeapp.pokemons.impl.data.datasource.PokemonService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class PokemonsDataModule {

    @Singleton
    @Binds
    abstract fun bindRepository(repository: DefaultPokemonsRepository): PokemonsRepository

    companion object {

        @Provides
        @Reusable
        internal fun provideService(
            retrofit: Retrofit,
        ): PokemonService = retrofit.create()

        @Provides
        @Reusable
        internal fun providePagingConfig(): PagingConfig = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PAGE_SIZE,
            initialLoadSize = PAGE_SIZE,
            enablePlaceholders = false,
        )
    }
}
