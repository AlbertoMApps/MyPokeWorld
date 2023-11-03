package com.alberto.mypokeworld.presentation.ui.screens.myPokedex

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.myPokedexNavigation(
    onNavigateToPokedex: () -> Unit,
    onNavigateToPokeGame: () -> Unit,
    onNavigateToGetPokemon: () -> Unit
) {
    composable(route = MyPokedexDestination.route) {
        MyPokedexScreen(
            onNavigateToPokedex = onNavigateToPokedex,
            onNavigateToPokeGame = onNavigateToPokeGame,
            onNavigateToGetPokemon = onNavigateToGetPokemon
        )
    }
}