package com.alberto.mypokeworld.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.alberto.mypokeworld.presentation.ui.screens.BottomMenu
import com.alberto.mypokeworld.presentation.ui.theme.MyPokeWorldTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPokeWorldTheme {
                val navHostController = rememberNavController()
                val buttonsVisible = remember { mutableStateOf(true) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,
                    bottomBar = {
                        BottomMenu(
                            navController = navHostController,
                            state = buttonsVisible,
                            modifier = Modifier
                        )
                    }
                ) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        MainActivityNavHost(navController = navHostController)
                    }
                }
            }
        }
    }
}