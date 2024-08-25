package com.example.lab5vd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5vd.ui.theme.Lab5VDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5VDTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ejemplos(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}




@Composable
fun Ejemplos(
    modifier: Modifier = Modifier
    ) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        ButtonExample()
        Spacer(modifier = Modifier.height(16.dp))
        TextExample()
        Spacer(modifier = Modifier.height(16.dp))
        EditTextExample()
        Spacer(modifier = Modifier.height(16.dp))
        ImageExample()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumnExample()


    }
}

@Composable
fun ButtonExample() {
    Button(
        onClick = { /* Acción al hacer clic */ },
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp, 50.dp)
            .background(color = Color.Blue, shape = RoundedCornerShape(8.dp)),
        enabled = true // si ponemos false se desactiva el boton
    ) {
        Text(text = "Agregar", color = Color.White)
    }
}

@Composable
fun TextExample() {
    Text(
        text = "Este es un ejemplo",
        modifier = Modifier
            .padding(16.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun EditTextExample() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Enter text here") },
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
            .padding(8.dp),
        maxLines = 1,
        textStyle = TextStyle(fontSize = 18.sp)
    )
}

@Composable
fun LazyColumnExample() {
    val itemsList = (1..3).map { "Item $it" }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(itemsList) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.LightGray)
                    .padding(8.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun ImageExample() {
    Image(
        painter = painterResource(id = R.drawable.patricioestrella),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .background(Color.Gray)
            .border(2.dp, Color.Black)
            .padding(8.dp),
        contentScale = ContentScale.Crop, // Cambia a Fit, FillWidth, etc.
        alignment = Alignment.Center,
        alpha = 0.8f // Transparencia
    )
}

@Preview(showBackground = true, name = "Ejemplos")
@Composable
fun GreetingPreview() {
    Lab5VDTheme {
        Column {
            ButtonExample()
            Spacer(modifier = Modifier.height(16.dp))
            TextExample()
            Spacer(modifier = Modifier.height(16.dp))
            EditTextExample()
            Spacer(modifier = Modifier.height(16.dp))
            ImageExample()
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumnExample()
        }
    }
}

