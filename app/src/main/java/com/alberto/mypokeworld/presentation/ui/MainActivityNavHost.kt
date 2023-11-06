package com.alberto.mypokeworld.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alberto.mypokeworld.presentation.ui.screens.Destinations
import com.alberto.mypokeworld.presentation.ui.screens.myPokedex.myPokedexNavigation
import com.alberto.mypokeworld.presentation.ui.screens.pokegame.pokeGameNavigation
import com.alberto.mypokeworld.presentation.ui.screens.pokemonExchange.pokemonExchangeNavigation

@Composable
fun MainActivityNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.MyPokedexDestination.route
    ) {
        myPokedexNavigation()
        pokeGameNavigation()
        pokemonExchangeNavigation()
    }
}