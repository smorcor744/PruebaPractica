package com.example.pruebapractica.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(navController: NavController, modifier: Modifier, nombre: String, dni: String){
    SecondBody(navController,modifier,nombre,dni )
}

@Composable
fun SecondBody(navController: NavController, modifier: Modifier, nombre: String, dni: String){
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        val name = validarNombre(nombre)
        val nif = validarDni(dni)


        Text(
            modifier = Modifier.padding(top = 150.dp),
            fontSize = 25.sp,
            text = name ?: "No hay datos recibidos"
        )
        Text(
            modifier = Modifier.padding(bottom = 25.dp, start = 10.dp,end = 10.dp),
            fontSize = 25.sp,
            text = nif ?: "No hay datos recibidos"
        )
        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Volver")
        }

    }
}


fun validarNombre(text: String?): String? {
    if (text != null && text.isNotBlank() ) {
        val texto = text.replace("(","").replace(" )","")

        if (texto != "") {
            return "Bienvenido $texto."
        }
        } else {
            return null
        }
    return null
}

fun validarDni(text: String?): String? {
    if (text != null && text.isNotBlank() ) {
        val texto = text.replace("(","").replace(" )","")

        if (texto != "") {
            return "Se a Registrado correctamente con su DNI: ${texto.replace(")","")}"
        }
    } else {
        return null
    }
    return null
}

