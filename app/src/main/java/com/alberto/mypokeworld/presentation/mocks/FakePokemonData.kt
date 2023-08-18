package com.alberto.mypokeworld.presentation.mocks

import com.alberto.mypokeworld.data.remote.model.FlavorTextEntry
import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.data.remote.model.PokemonSprites
import com.alberto.mypokeworld.data.remote.model.Specie

val fakePokemon = Pokemon(
    id = 1000,
    name = "Gholdengo",
    baseExperience = 100,
    height = 10,
    weight = 10,
    sprites = PokemonSprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1000.pn")
)

val fakeSpecie = Specie(
    isBaby = "No",
    isLegendary = "No",
    flavorTextEntries = listOf(FlavorTextEntry("Text of the entry for this pokemon"))
)