package com.alberto.mypokeworld.data.remote.model

data class User(
    val id: Int,
    val name: String,
    val userExperience: Int,
    val level: Int,
    val pokemonList: List<Pokemon>,
    val specieList: List<Specie>
)