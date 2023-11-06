package com.alberto.mypokeworld.presentation.ui.screens.pokemonExchange

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alberto.mypokeworld.presentation.ui.screens.Destinations

fun NavGraphBuilder.pokemonExchangeNavigation() {
    composable(route = Destinations.PokemonExchangeDestination.route) {
        PokemonExchangeScreen()
    }
}