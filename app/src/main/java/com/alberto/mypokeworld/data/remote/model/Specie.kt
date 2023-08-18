package com.alberto.mypokeworld.data.remote.model

import com.google.gson.annotations.SerializedName

class Specie(
    @SerializedName("is_baby")
    val isBaby: String,
    @SerializedName("is_legendary")
    val isLegendary: String,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>
)