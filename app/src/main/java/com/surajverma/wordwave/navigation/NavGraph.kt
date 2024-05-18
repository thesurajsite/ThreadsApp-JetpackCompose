package com.surajverma.wordwave.navigation

import android.app.Notification
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surajverma.wordwave.screens.AddThreads
import com.surajverma.wordwave.screens.BottomNav
import com.surajverma.wordwave.screens.Home
import com.surajverma.wordwave.screens.Notifications
import com.surajverma.wordwave.screens.Profile
import com.surajverma.wordwave.screens.Search
import com.surajverma.wordwave.screens.Splash

@Composable
fun NavGraph(navController: NavHostController){
    
    NavHost(navController = navController,
        startDestination = Routes.Splash.routes){

        composable(Routes.Splash.routes){
            Splash(navController)
        }

        composable(Routes.Home.routes){
            Home()
        }

        composable(Routes.Profile.routes){
            Profile()
        }

        composable(Routes.AddThreads.routes){
            AddThreads()
        }

        composable(Routes.Search.routes){
            Search()
        }

        composable(Routes.Notifications.routes) {
            Notifications()
        }

        composable(Routes.BottomNav.routes) {
            BottomNav(navController)
        }


    }


}