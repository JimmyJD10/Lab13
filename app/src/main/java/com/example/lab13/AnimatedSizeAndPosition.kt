package com.example.lab13

import androidx.compose.animation.core.animateDpAsState
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
fun AnimatedSizeAndPosition(modifier: Modifier = Modifier) {
    var isClicked by remember { mutableStateOf(false) }

    val boxSize by animateDpAsState(
        targetValue = if (isClicked) 200.dp else 100.dp
    )

    val boxOffset by animateDpAsState(
        targetValue = if (isClicked) 200.dp else 0.dp
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { isClicked = !isClicked }) {
            Text(text = "Mover y cambiar tamaño")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(boxSize)
                .offset(y = boxOffset) // Desplazamiento en el eje Y= abajo
                .background(Color(0xFF80D8FF))
        ){
            Text(
                text = "JD Jimmy",
                color = Color(0xFF000000),
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
