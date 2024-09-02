package com.example.fiapclimatempo.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LocationButton(text: String, lat: String, long: String, navController: NavController) {
    Button(
        onClick = { navController.navigate("climate-forecast/$text?lat=$lat&long=$long") }, // Para quem for utilizar lat e long na chamada da API, manipular o navigate de acordo
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black,
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}