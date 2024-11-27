package com.example.pruebapractica.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebapractica.navigation.AppScreen

@Composable
fun FirstScreen(navController: NavController, modifier: Modifier ){
    FirstBody(navController,modifier)

}

@Composable
fun FirstBody(navController: NavController, modifier: Modifier){
    val nombre = remember { mutableStateOf("") }
    val dni = remember { mutableStateOf("") }
    val list = Pair<String, String>(nombre.value, dni.value)

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {

        Column(
            modifier = Modifier.padding(top = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Prueba Practica",
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Rellena los siguentes campos.",
                fontSize = 25.sp
            )
        }
        Column(
            modifier = Modifier.padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = nombre.value,
                onValueChange = { nombre.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Escribe tu nombre.") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = dni.value,
                onValueChange = { dni.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Escribe tu DNI.") }
            )
            Button(
                onClick = { navController.navigate(route = AppScreen.SecondScreen.route + "/$list") }
            ) {
                Text("Login")
            }
        }
    }
}

