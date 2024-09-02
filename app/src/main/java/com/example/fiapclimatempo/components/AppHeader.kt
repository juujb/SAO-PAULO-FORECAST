package com.example.fiapclimatempo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fiapclimatempo.R

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 64.dp)
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "São Paulo Forecast",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            color = Color.White
        )
        val imageModifier = Modifier
            .size(150.dp)
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = imageModifier
        )
    }
}

