package com.khurram.motra_xpense.routes

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Mail : Screen("mail_screen")
}
