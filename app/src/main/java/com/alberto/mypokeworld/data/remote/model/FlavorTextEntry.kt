package com.alberto.mypokeworld.data.remote.model

import com.google.gson.annotations.SerializedName

class FlavorTextEntry(
    @SerializedName("flavor_text")
    val flavorText: String
)