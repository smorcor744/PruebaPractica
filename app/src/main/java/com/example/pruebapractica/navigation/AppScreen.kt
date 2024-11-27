package com.example.pruebapractica.navigation

sealed class AppScreen(val route : String) {
    object FirstScreen: AppScreen("FirstScreen")
    object SecondScreen: AppScreen("SecondScreen")
}