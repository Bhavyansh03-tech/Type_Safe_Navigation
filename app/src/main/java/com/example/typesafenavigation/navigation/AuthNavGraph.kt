package com.example.typesafenavigation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.typesafenavigation.screens.LoginScreen
import com.example.typesafenavigation.screens.SignupScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation<AUTH>(
        startDestination = Login
    ){
        composable<Login>{
            LoginScreen(navController = navController)
        }
        composable<Signup>{
            SignupScreen(navController = navController)
        }
    }
}