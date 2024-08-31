package com.example.fiapclimatempo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiapclimatempo.components.AppHeader
import com.example.fiapclimatempo.components.LocationButton

@Composable
fun LocationSelection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp),
    ) {
        AppHeader(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        )
        Text(
            text = "Selecione a Localização:",
            style = MaterialTheme.typography.labelLarge,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 80.dp, bottom = 500.dp)
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            LocationButton(
                text = "São Paulo",
                lat = "-23.5489",
                long = "-46.6388",
                navController = navController
            )
            LocationButton(
                text = "Diadema",
                lat = "-23.6865",
                long = "-46.6234",
                navController = navController
            )
            LocationButton(
                text = "São Bernardo do Campo",
                lat = "-23.6944",
                long = "-46.5654",
                navController = navController
            )
            LocationButton(
                text = "Santo André",
                lat = "-23.6666",
                long = "-46.5322",
                navController = navController
            )
        }
    }
}
