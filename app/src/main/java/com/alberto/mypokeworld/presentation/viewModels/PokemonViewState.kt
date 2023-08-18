package com.alberto.mypokeworld.presentation.viewModels

import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.data.remote.model.Specie

class PokemonViewState(
    val isLoading: Boolean = false,
    val data: Pokemon? = null,
    val errorMessage: String = ""
)

class SpecieViewState(
    val isLoading: Boolean = false,
    val data: Specie? = null,
    val errorMessage: String = ""
)