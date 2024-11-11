import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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

enum class ScreenState { Cargando, Contenido, Error }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContent(modifier: Modifier = Modifier) {
    var currentState by remember { mutableStateOf(ScreenState.Cargando) }
    var isDarkMode by remember { mutableStateOf(false) }

    LaunchedEffect(currentState) {
        when (currentState) {
            ScreenState.Cargando -> {
                delay(2000)
                currentState = ScreenState.Contenido
            }
            ScreenState.Contenido -> {
                delay(2000)
                currentState = ScreenState.Error
            }
            ScreenState.Error -> {
                delay(2000)
                currentState = ScreenState.Cargando
            }
        }
    }

    val backgroundColor = if (isDarkMode) Color.Black else Color.White
    val textColor = if (isDarkMode) Color.White else Color.Black

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Transición animada entre los estados
        AnimatedContent(
            targetState = currentState,
            transitionSpec = {
                fadeIn(animationSpec = tween(600)) with
                        fadeOut(animationSpec = tween(600))
            }
        ) { targetState ->
            when (targetState) {
                ScreenState.Cargando -> Text(
                    "Cargando...",
                    fontSize = 24.sp,
                    color = textColor
                )
                ScreenState.Contenido -> Text(
                    "Contenido cargado",
                    fontSize = 24.sp,
                    color = textColor
                )
                ScreenState.Error -> Text(
                    "Ocurrió un error",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            currentState = when (currentState) {
                ScreenState.Cargando -> ScreenState.Contenido
                ScreenState.Contenido -> ScreenState.Error
                ScreenState.Error -> ScreenState.Cargando
            }
        }) {
            Text("Cambiar Estado", color = textColor)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { isDarkMode = !isDarkMode }) {
            Text(
                text = if (isDarkMode) "Modo Claro" else "Modo Oscuro",
                color = textColor
            )
        }
    }
}

