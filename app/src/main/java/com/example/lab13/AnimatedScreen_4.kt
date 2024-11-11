package com.example.lab13

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedScreen_4(modifier: Modifier = Modifier) {
    var isClicked by remember { mutableStateOf(false) }
    var isDarkMode by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(true) }

    val size by animateDpAsState(targetValue = if (isClicked) 200.dp else 100.dp, animationSpec = tween(600))
    val color by animateColorAsState(targetValue = if (isClicked) Color.Red else Color.Green, animationSpec = tween(600))

    val backgroundColor = if (isDarkMode) Color.Black else Color.White
    val textColor = if (isDarkMode) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color)
                .clickable {
                    isClicked = !isClicked
                }
        ){
            Text(
                text = "JD Jimmy",
                color = Color(0xFF000000),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = showButton,
            enter = slideInVertically(animationSpec = tween(600)) { fullHeight -> fullHeight },
            exit = slideOutVertically(animationSpec = tween(600)) { fullHeight -> fullHeight }
        ) {
            Button(onClick = { showButton = false }) {
                Text("Desaparecer", color = textColor)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            isDarkMode = !isDarkMode
        }) {
            Text(
                text = if (isDarkMode) "Modo Claro" else "Modo Oscuro",
                color = textColor
            )
        }
    }
}

