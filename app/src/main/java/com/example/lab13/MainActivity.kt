package com.example.lab13

import AnimatedContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab13.ui.theme.Lab13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab13Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        //AnimatedVisibility(modifier = Modifier.weight(1f))
                        //Spacer(modifier = Modifier.height(16.dp))
                        //AnimatedColorChange(modifier = Modifier.weight(1f))
                        //Spacer(modifier = Modifier.height(16.dp))
                        //AnimatedSizeAndPosition(modifier = Modifier.weight(1f))
                        //Spacer(modifier = Modifier.height(16.dp))
                        //AnimatedContent(modifier = Modifier.weight(1f))
                        //Spacer(modifier = Modifier.height(16.dp))
                        //AnimatedScreen_4(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
