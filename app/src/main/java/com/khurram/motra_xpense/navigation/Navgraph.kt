package com.khurram.motra_xpense.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.khurram.motra_xpense.routes.Screens
import com.khurram.motra_xpense.screens.HomeScreen
import com.khurram.motra_xpense.screens.MailScreen
import com.khurram.motra_xpense.screens.SignUpScreen
import com.khurram.motra_xpense.screens.SplashScreen

    @Composable
    fun SetNavGraph(navController: NavHostController)
    {

        NavHost(
            navController = navController,
            startDestination = Screens.Splash.route
        ) {
            composable(route = Screens.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(route = Screens.Reg.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Screens.Mail.route) {
                MailScreen(navController = navController)
            }
            composable(route = Screens.SignUp.route) {
                SignUpScreen(navController = navController)
            }
        }

}