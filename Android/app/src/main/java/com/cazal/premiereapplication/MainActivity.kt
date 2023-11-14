package com.cazal.premiereapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cazal.premiereapplication.Profile.Profile
import com.cazal.premiereapplication.ui.Navigation.navigation

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val windowSizeClass = calculateWindowSizeClass(this)
            val navController = rememberNavController()


            NavHost(navController = navController, startDestination = "profile") {
                composable("profile") { Profile(windowSizeClass, navController) }
                composable("Navigation") { navigation(windowSizeClass) }
            }
        }
    }
}



