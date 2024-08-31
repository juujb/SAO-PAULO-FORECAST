package com.example.fiapclimatempo.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LocationButton(modifier: Modifier = Modifier, text: String, lat: String, long: String, navController: NavController) {
    Button(
        onClick = { navController.navigate("climate-forecast/$text?lat=$lat&long=$long") }, // Para quem for utilizar lat e long na chamada da API, manipular o navigate de acordo
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelLarge,
            fontSize = 20.sp
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
}