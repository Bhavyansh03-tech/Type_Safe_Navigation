package com.example.typesafenavigation.navigation

import kotlinx.serialization.Serializable

@Serializable object AUTH
@Serializable object ROOT
@Serializable object Home
@Serializable object Login
@Serializable object Signup
@Serializable
data class Detail(
    val name: String,
    val age: Int
)