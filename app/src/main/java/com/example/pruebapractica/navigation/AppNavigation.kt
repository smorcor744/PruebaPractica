package com.example.pruebapractica.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pruebapractica.screens.FirstScreen
import com.example.pruebapractica.screens.SecondScreen



@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.FirstScreen.route
    ) {
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(
            route = AppScreen.SecondScreen.route + "/{list}",
            arguments = listOf(navArgument(name = "list") {
                type = NavType.StringType
            })
        ) {
            // Cojo los valores que me a pasado la primera pantalla en String
            val listString = it.arguments?.getString("list")
            // Creo dos variable
            var nombre : String = ""
            var dni : String = ""

            //Paso el pair que me a pasado a lista y le asigno los valores a las variables de antes
            listString?.let { str ->
                val parts = str.split(",")
                nombre = parts[0]
                dni = parts[1]
            }
            SecondScreen(
                navController = navController,
                nombre = nombre,
                dni = dni,
                modifier = modifier
            )
        }
    }
}
