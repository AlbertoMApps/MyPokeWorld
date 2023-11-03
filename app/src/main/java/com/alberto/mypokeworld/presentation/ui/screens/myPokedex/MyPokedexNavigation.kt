package com.alberto.mypokeworld.presentation.ui.screens.myPokedex

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alberto.mypokeworld.presentation.ui.screens.Destinations

fun NavGraphBuilder.myPokedexNavigation() {
    composable(route = Destinations.MyPokedexDestination.route) {
        MyPokedex()
    }
}