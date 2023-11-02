package com.alberto.mypokeworld.presentation.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alberto.mypokeworld.R
import com.alberto.mypokeworld.data.remote.model.Pokemon
import com.alberto.mypokeworld.data.remote.model.Specie

@Composable
fun PokemonCardContent(
    pokemon: Pokemon?,
    specie: Specie?
) {
    if (pokemon != null && specie != null) {
        PokemonUncoveredCardScreen(pokemon = pokemon, specie = specie)
    } else {
        PokemonCoveredScreen()
    }
}


@Composable
fun PokemonUncoveredCardScreen(
    pokemon: Pokemon?,
    specie: Specie?
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = pokemon?.sprites?.frontDefaultImage,
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = (pokemon?.name ?: "No name loaded").uppercase(),
            style = MaterialTheme.typography.h3.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = specie?.flavorTextEntries?.get(0)?.flavorText.toString(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun PokemonCoveredScreen() {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(300.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}