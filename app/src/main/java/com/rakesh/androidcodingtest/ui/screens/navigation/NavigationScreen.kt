package com.rakesh.androidcodingtest.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rakesh.androidcodingtest.ui.screens.home.HomeScreen
import com.rakesh.androidcodingtest.ui.screens.home.HomeViewModel
import com.rakesh.androidcodingtest.ui.screens.search.SearchScreen

@Composable
fun NavigationView(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController, homeViewModel)
        }
        composable("search") {
            SearchScreen(
                onHome = { navController.popBackStack() }
            )
        }
    }
}