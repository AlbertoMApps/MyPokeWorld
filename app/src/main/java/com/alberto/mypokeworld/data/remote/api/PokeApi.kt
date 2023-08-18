package com.alberto.mypokeworld.data.remote.api

import com.alberto.mypokeworld.data.remote.commons.Constants.POKE_API_FEED
import com.alberto.mypokeworld.data.remote.commons.Constants.POKE_SPECIE_API_FEED
import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.data.remote.model.Specie
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET(POKE_API_FEED)
    fun getPokemon(@Path("id") id: String? = null): Observable<Pokemon>

    @GET(POKE_SPECIE_API_FEED)
    fun getSpecies(@Path("id") id: String? = null): Observable<Specie>

}