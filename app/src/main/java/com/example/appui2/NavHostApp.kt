package com.example.appui2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appui2.screens.FlashScreen
import com.example.appui2.screens.Home
import com.example.appui2.screens.LogInUI
import com.example.appui2.screens.Welcome

@Composable
fun NavHostApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "flash") {
        composable("flash") {
            FlashScreen(navController)
        }
        composable("login") {
            LogInUI(navController)
        }
        composable("welcome") {
            Welcome(navController)
        }
        composable("home") {
            Home(navController)
        }
    }
}