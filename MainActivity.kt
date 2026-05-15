package com.kutira.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kutira.app.ui.screens.BusinessDetailScreen
import com.kutira.app.ui.screens.HomeScreen
import com.kutira.app.ui.screens.MyProfileScreen
import com.kutira.app.ui.theme.KutiraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            KutiraTheme {
                KutiraApp()
            }
        }
    }
}

@Composable
fun KutiraApp() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onBusinessClick = { id -> nav.navigate("detail/$id") },
                onMyProfileClick = { nav.navigate("me") }
            )
        }
        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { entry ->
            val id = entry.arguments?.getString("id") ?: return@composable
            BusinessDetailScreen(businessId = id, onBack = { nav.popBackStack() })
        }
        composable("me") {
            MyProfileScreen(onBack = { nav.popBackStack() })
        }
    }
}
