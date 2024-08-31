package com.example.fiapclimatempo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Fazer telinha para mostra o clima (se necessário, fazer componentes na pasta específica)
@Composable
fun ClimateForecast(navController: NavController, lat: String?, long: String?, city: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "$city")
        Text(text = "$lat")
        Text(text = "$long")
    }
}

// Criar função para bater na API open-meteo, com as informações de latitude e longitude