package vch.compose_ex.ex2.ui_ex2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vch.compose_ex.ex2.ui_ex2.screen.HomeScreen

@Composable
fun AppNavigationGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) { HomeScreen() }
    }
}