package com.khurram.motra_xpense.routes

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object Reg : Screens("reg_screen")
    object Mail : Screens("mail_screen")
    object SignUp : Screens("signup_screen")
}
