package com.khurram.motra_xpense.routes

sealed class BottomScreens(val route: String) {
    object Home : BottomScreens("home_screen")
    object Transaction : BottomScreens("transaction_screen")
    object Budget : BottomScreens("budget_screen")
    object Profile : BottomScreens("profile_screen")
    object Add : BottomScreens("add_screen")
}
