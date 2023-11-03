package com.alberto.mypokeworld.presentation.ui.screens.pokegame

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alberto.mypokeworld.presentation.ui.screens.Destinations

fun NavGraphBuilder.pokeGameNavigation() {
    composable(route = Destinations.PokegameDestination.route) {
        PokegameScreen()
    }
}