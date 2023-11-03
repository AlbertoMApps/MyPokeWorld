package com.alberto.mypokeworld.presentation.ui.screens.myPokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alberto.mypokeworld.R
import com.alberto.mypokeworld.presentation.ui.screens.BottomMenu
import com.alberto.mypokeworld.presentation.ui.screens.BottomMenuContent


@Composable
fun MyPokedexScreen(
    onNavigateToPokedex: () -> Unit,
    onNavigateToPokeGame: () -> Unit,
    onNavigateToGetPokemon: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        MyPokedex()
        BottomMenu(
            items = listOf(
                BottomMenuContent("Pokedex", R.drawable.pokedex_icon),
                BottomMenuContent("Pokegame", R.drawable.pokegame_icon),
                BottomMenuContent("Get Pokemon", R.drawable.pokemon_icon)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(15.dp)
                .align(Alignment.BottomCenter),
            onNavigateToPokedex = {
                onNavigateToPokedex
            },
            onNavigateToPokeGame = {
                onNavigateToPokeGame
            },
            onNavigateToGetPokemon = {
                onNavigateToGetPokemon
            }
        )
    }
}
