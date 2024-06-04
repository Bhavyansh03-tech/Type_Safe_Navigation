package com.example.typesafenavigation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.typesafenavigation.screens.DetailScreen
import com.example.typesafenavigation.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation<ROOT>(
        startDestination = Home
    ){
        composable<Home>{
            HomeScreen(navController = navController)
        }
        composable<Detail>{
            val args = it.toRoute<Detail>()
            DetailScreen(navController = navController, args.age, args.name)
        }
    }
}