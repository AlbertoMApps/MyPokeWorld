package com.alberto.mypokeworld.presentation.viewModels

import com.alberto.mypokeworld.data.remote.model.Pokemon

class PokemonViewState(
    val isLoading: Boolean = false,
    val data: Pokemon? = null,
    val errorMessage: String = ""
)