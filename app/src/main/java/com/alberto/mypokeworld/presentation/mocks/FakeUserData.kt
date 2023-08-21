package com.alberto.mypokeworld.presentation.mocks

import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.data.remote.model.Specie
import com.alberto.mypokeworld.data.remote.model.User

fun getUser(pokemonList: List<Pokemon>, specieList: List<Specie>) =
    User(
        0,
        "Alberto",
        100,
        2,
        pokemonList,
        specieList
    )