package com.example.fiapclimatempo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fiapclimatempo.screens.ClimateForecast
import com.example.fiapclimatempo.screens.LocationSelection
import com.example.fiapclimatempo.ui.theme.FIAPClimaTempoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIAPClimaTempoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "location-selector",
                    ) {
                        composable(route = "location-selector") {
                            LocationSelection(navController)
                        }
                        composable(
                            route = "climate-forecast/{city}?lat={lat}&long={long}",
                            arguments = listOf(
                                navArgument(name = "lat") {
                                    defaultValue = ""
                                },
                                navArgument(name = "long") {
                                    defaultValue = ""
                                },
                                navArgument(name = "city") {
                                    defaultValue = "Nenhuma Cidade Selecionada"
                                }
                            )
                        ) { backStackEntry ->
                            val lat = backStackEntry.arguments?.getString("lat")
                            val long = backStackEntry.arguments?.getString("long")
                            val city = backStackEntry.arguments?.getString("city")

                            ClimateForecast(navController, lat!!, long!!, city!!)
                        }
                    }
                }
            }
        }
    }
}
