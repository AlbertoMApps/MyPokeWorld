package com.alberto.mypokeworld.data.remote.repository

import com.alberto.mypokeworld.data.remote.api.PokeApi
import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.domain.PokemonRepositoryService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PokemonRepositoryImplementation @Inject constructor(
    private val pokeApi: PokeApi
) : PokemonRepositoryService {

    override fun getPokemon(
        pokeId: String
    ): Observable<Pokemon> =
        pokeApi.getPokemon(pokeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}