package com.surajverma.wordwave.navigation

sealed class Routes(val routes: String) {

    object Home: Routes("home")
    object AddThreads: Routes("addThreads")
    object Profile: Routes("profile")
    object Search: Routes("search")
    object Splash: Routes("splash")
    object Notifications: Routes("notifications")
    object BottomNav: Routes("bottom_nav")
}