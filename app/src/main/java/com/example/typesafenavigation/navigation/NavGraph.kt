package com.example.typesafenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTH
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}