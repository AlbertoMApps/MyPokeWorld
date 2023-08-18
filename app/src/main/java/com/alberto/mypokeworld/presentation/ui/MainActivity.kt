package com.alberto.mypokeworld.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.alberto.mypokeworld.presentation.ui.theme.MyPokeWorldTheme
import com.alberto.mypokeworld.presentation.viewModels.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPokeWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyPokedexScreen()
                }
            }
        }
    }
}

@Composable
fun MyPokedexScreen(
    viewModel: PokemonViewModel = hiltViewModel()
) {
    viewModel.getPokemon("1")
    viewModel.getSpecie("1")
    val pokemon = viewModel.pokemonViewState.value.data
    val specie = viewModel.specieViewState.value.data

    Column {
        Text(
            text = "Hello ${pokemon?.name}"
        )
        Text(
            text = specie?.flavorTextEntries?.get(0)?.flavorText.toString()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPokeWorldTheme {
        MyPokedexScreen()
    }
}