package com.aura.zenith

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuraTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF0A0A0A)) {
                    AuraScreen()
                }
            }
        }
    }
}

@Composable
fun AuraScreen() {
    var drive by remember { mutableStateOf(1.5f) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("AURA ZENITH", color = Color(0xFFFFD700), fontSize = 32.sp)
        Text("Rack Analógico v1.0", color = Color.Gray, fontSize = 14.sp)
        
        Spacer(modifier = Modifier.height(50.dp))
        
        Text("Calidez de Bulbo: ${"%.1f".format(drive)}x", color = Color.White)
        Slider(
            value = drive,
            onValueChange = { drive = it },
            valueRange = 1f..5f,
            colors = SliderDefaults.colors(thumbColor = Color(0xFFFFD700), activeTrackColor = Color(0xFFFFD700))
        )
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Button(
            onClick = { /* Aquí activaremos el motor */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700))
        ) {
            Text("ACTIVAR NÚCLEO", color = Color.Black)
        }
    }
}

@Composable
fun AuraTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
