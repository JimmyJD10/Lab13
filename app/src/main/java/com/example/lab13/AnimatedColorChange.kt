package com.example.lab13

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimatedColorChange(modifier: Modifier = Modifier) {
    var color_uno by remember { mutableStateOf(true) }

    val backgroundColor by animateColorAsState(
        targetValue = if (color_uno) Color(0xFF5DC1EE) else Color(0xFF5AE726),
                animationSpec = tween(durationMillis = 1000)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { color_uno = !color_uno }) {
            Text(text = "Cambiar color de fondo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(backgroundColor)
        ){
            Text(
                text = "JD Jimmy",
                color = Color(0xFF000000),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
