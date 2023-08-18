package com.alberto.mypokeworld.domain

import com.alberto.mypokeworld.data.remote.model.Pokemon
import io.reactivex.rxjava3.core.Observable

interface PokemonRepositoryService {
    fun getPokemon(
        pokeId: String
    ): Observable<Pokemon>

}