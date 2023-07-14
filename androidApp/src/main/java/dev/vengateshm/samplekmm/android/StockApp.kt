package dev.vengateshm.samplekmm.android

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.vengateshm.samplekmm.android.presentation.home.HomeScreen
import dev.vengateshm.samplekmm.android.presentation.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun StockApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                val viewModel = koinViewModel<HomeViewModel>()
                HomeScreen(viewModel.uiState)
            }
        }
    }
}