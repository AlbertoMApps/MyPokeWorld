package com.alberto.mypokeworld.presentation.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.alberto.mypokeworld.domain.PokemonRepositoryService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepositoryService: PokemonRepositoryService
) : ViewModel() {

    private val _pokemonState = mutableStateOf(PokemonViewState())
    val pokemonViewState = _pokemonState

    private val _specieState = mutableStateOf(SpecieViewState())
    val specieViewState = _specieState

    fun getPokemon(pokeId: String) {
        pokemonRepositoryService.getPokemon(pokeId)
            .subscribe({
                _pokemonState.value = PokemonViewState(
                    isLoading = false,
                    data = it
                )
            }, {
                _pokemonState.value = PokemonViewState(
                    isLoading = false,
                    errorMessage = it.message ?: "An error occurred loading your pokemon"
                )
            })
    }

    fun getSpecie(pokeId: String) {
        pokemonRepositoryService.getSpecie(pokeId)
            .subscribe({
                _specieState.value = SpecieViewState(
                    isLoading = false,
                    data = it
                )
            }, {
                _specieState.value = SpecieViewState(
                    isLoading = false,
                    errorMessage = it.message ?: "An error occurred loading your specie"
                )
            })
    }

}