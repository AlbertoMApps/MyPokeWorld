package com.alberto.mypokeworld.presentation.ui.screens

import com.alberto.mypokeworld.R

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: Int
) {

    object MyPokedexDestination : Destinations(
        route = "pokedex",
        title = "Pokedex",
        icon = R.drawable.pokedex_icon
    )

    object PokegameDestination : Destinations(
        route = "pokegame",
        title = "Pokegame",
        icon = R.drawable.pokegame_icon
    )

    object PokemonExchangeDestination : Destinations(
        route = "pokemon",
        title = "Pokemon",
        icon = R.drawable.pokemon_icon
    )

}