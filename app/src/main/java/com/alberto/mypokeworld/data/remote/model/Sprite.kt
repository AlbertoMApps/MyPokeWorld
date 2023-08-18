package com.alberto.mypokeworld.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonSprites(
    @SerializedName("front_default")
    val frontDefaultImage: String
)