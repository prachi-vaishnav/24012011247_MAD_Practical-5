package com.example.a24012011247_mad_practical_5


import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(context: Context = LocalContext.current){
    val navController=rememberNavController()
    NavHost(navController=navController, startDestination = "login"){
        composable ("login"){
            LoginScreen(navController=navController, context = context)
        }
        composable("register"){
            RegisterScreen(navController=navController, context = context)
        }
    }
}