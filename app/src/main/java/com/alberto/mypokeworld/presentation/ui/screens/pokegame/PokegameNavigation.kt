package com.alberto.mypokeworld.presentation.ui.screens.pokegame

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.pokeGameNavigation() {
    composable(route = MyPokegameDestination.route) {
        PokegameScreen()
    }
}