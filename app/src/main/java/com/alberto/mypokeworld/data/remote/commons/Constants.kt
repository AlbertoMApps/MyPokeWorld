package com.alberto.mypokeworld.data.remote.commons

const val API_VERSION = "/api/v2/"

object Constants {
    const val POKE_API_BASE_URL = "https://pokeapi.co"
    const val POKE_API_FEED = API_VERSION + "pokemon/{id}" //It can pass id or name
    const val POKE_SPECIE_API_FEED = API_VERSION + "pokemon-species/{id}" //It can pass id or name
}