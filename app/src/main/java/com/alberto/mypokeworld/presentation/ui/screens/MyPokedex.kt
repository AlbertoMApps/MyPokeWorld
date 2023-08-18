package com.alberto.mypokeworld.presentation.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.data.remote.model.Specie
import com.alberto.mypokeworld.presentation.mocks.fakePokemon
import com.alberto.mypokeworld.presentation.mocks.fakeSpecie
import com.alberto.mypokeworld.presentation.ui.theme.MyPokeWorldTheme
import com.alberto.mypokeworld.presentation.viewModels.PokemonViewModel

@Composable
fun MyPokedex(
    viewModel: PokemonViewModel = hiltViewModel()
) {
    viewModel.getPokemon("1")
    viewModel.getSpecie("1")
    val pokemon = viewModel.pokemonViewState.value.data
    val specie = viewModel.specieViewState.value.data
    val isLoading = viewModel.specieViewState.value.isLoading
    MyPokedexScreen(
        pokemon, specie, isLoading
    )
}

@Composable
private fun MyPokedexScreen(
    pokemon: Pokemon?,
    specie: Specie?,
    isLoading: Boolean
) {
    AnimatedVisibility(
        visible = !isLoading,
        enter = slideInVertically(),
        exit = slideOutVertically()
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.onPrimary,
            elevation = 4.dp
        ) {
            PokemonCardContent(pokemon, specie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPokedexScreenPreview() {
    MyPokeWorldTheme {
        MyPokedexScreen(pokemon = fakePokemon, specie = fakeSpecie, false)
    }
}