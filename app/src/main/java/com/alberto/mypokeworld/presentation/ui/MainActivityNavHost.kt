package com.alberto.mypokeworld.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alberto.mypokeworld.presentation.ui.screens.myPokedex.MyPokedexDestination
import com.alberto.mypokeworld.presentation.ui.screens.myPokedex.myPokedexNavigation
import com.alberto.mypokeworld.presentation.ui.screens.pokegame.MyPokegameDestination
import com.alberto.mypokeworld.presentation.ui.screens.pokegame.pokeGameNavigation

@Composable
fun MainActivityNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MyPokedexDestination.route
    ) {
        myPokedexNavigation(
            onNavigateToPokedex = {
                navController.navigate(route = MyPokedexDestination.route)
            },
            onNavigateToPokeGame = {
                navController.navigate(route = MyPokegameDestination.route)
            },
            onNavigateToGetPokemon = {}
        )
        pokeGameNavigation()
    }
}