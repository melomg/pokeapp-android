package com.melih.android.impl.wiring

import com.melih.android.pokeapp.pokemons.api.data.PokemonsRepository
import com.melih.android.pokeapp.pokemons.impl.data.DefaultPokemonsRepository
import com.melih.android.pokeapp.pokemons.impl.data.PokemonService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.create

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
            retrofit: Retrofit
        ): PokemonService = retrofit.create()
    }
}
