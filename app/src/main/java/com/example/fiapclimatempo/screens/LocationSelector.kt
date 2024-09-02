package com.example.fiapclimatempo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fiapclimatempo.components.AppHeader
import com.example.fiapclimatempo.components.LocationButton
import consultaclima.model.Daily

@Composable
fun LocationSelection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00BFFF)),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppHeader()
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Selecione a localização:",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier
                    .padding(top = 30.dp),
                color = Color.White
            )
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(30.dp),
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
}