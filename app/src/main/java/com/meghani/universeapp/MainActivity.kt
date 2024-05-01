package com.meghani.universeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.meghani.universeapp.screens.DashboardScreen
import com.meghani.universeapp.screens.DetailScreen
import com.meghani.universeapp.ui.theme.UniverseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniverseAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Route.DASHBOARD) {
                        composable(Route.DASHBOARD) {
                            DashboardScreen(navController)
                        }
                        /*composable("${Route.DETAIL_PAGE}/{index}") { backStackEntry ->
                            val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
                            DetailScreen(index)
                        }*/
                        composable("${Route.DETAIL_PAGE}/{index}",
                            arguments = listOf(
                                navArgument("index") { type = NavType.IntType }
                            )) { backStackEntry ->
                            val index = backStackEntry.arguments?.getInt("index") ?: 0
                            DetailScreen(index, navController =  navController)
                        }


                    }


                }

            }

        }
    }
}



