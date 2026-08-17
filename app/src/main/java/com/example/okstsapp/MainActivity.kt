package com.example.okstsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme(background = Color(0xFF121212), surface = Color(0xFF1E1E1E), primary = Color(0xFF03A9F4))) {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    var selectedTab by remember { mutableStateOf("zakazka") }
    
    // Поля (спрощено для прикладу)
    var zakCode by remember { mutableStateOf("") }
    var statusMessage by remember { mutableStateOf("") }
    val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF121212))) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())) {
            Text(text = "Журнал робіт OK STS", color = Color.White, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(value = zakCode, onValueChange = { zakCode = it }, label = { Text("Код замовлення") }, modifier = Modifier.fillMaxWidth())
            
            Button(onClick = { statusMessage = "Дані збережено!" }, modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
                Text("Зберегти")
            }
            if (statusMessage.isNotEmpty()) Text(text = statusMessage, color = Color.Green, modifier = Modifier.padding(top = 10.dp))
        }
    }
}
