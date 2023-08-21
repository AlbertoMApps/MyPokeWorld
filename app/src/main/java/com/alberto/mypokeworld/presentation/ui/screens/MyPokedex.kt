package com.alberto.mypokeworld.presentation.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alberto.mypokeworld.data.remote.model.User
import com.alberto.mypokeworld.presentation.mocks.fakePokemon
import com.alberto.mypokeworld.presentation.mocks.fakeSpecie
import com.alberto.mypokeworld.presentation.mocks.getUser
import com.alberto.mypokeworld.presentation.ui.theme.MyPokeWorldTheme
import com.alberto.mypokeworld.presentation.viewModels.PokemonViewModel

@Composable
fun MyPokedex(
    viewModel: PokemonViewModel = hiltViewModel()
) {
    viewModel.getPokemon("1")
    viewModel.getSpecie("1")
    val pokemon = viewModel.pokemonViewState.value.data//Just for testing for now
    val specie = viewModel.specieViewState.value.data//Just for testing
    val isLoading = viewModel.specieViewState.value.isLoading
    val user = getUser(
        listOf(pokemon ?: fakePokemon),
        listOf(
            specie ?: fakeSpecie
        )
    ) //This will need to change to other data structure to use in the app.

    MyPokedexScreen(
        user, isLoading
    )

}

@Composable
private fun MyPokedexScreen(
    user: User,
    isLoading: Boolean
) {
    AnimatedVisibility(
        visible = !isLoading,
        enter = slideInVertically(),
        exit = slideOutVertically()
    ) {
        LazyColumn(
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            items(user.level * 10) { index: Int ->
                Card(
                    backgroundColor = MaterialTheme.colors.onPrimary,
                    elevation = 4.dp
                ) {
                    PokemonCardContent(user.pokemonList[index - 1], user.specieList[index - 1])
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyPokedexScreenPreview() {
    MyPokeWorldTheme {
        MyPokedexScreen(user = getUser(listOf(fakePokemon), listOf(fakeSpecie)), false)
    }
}