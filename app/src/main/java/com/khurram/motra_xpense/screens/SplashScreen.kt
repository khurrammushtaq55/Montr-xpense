package com.khurram.motra_xpense.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.routes.Screen
import com.khurram.motra_xpense.ui.theme.Violet100

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Violet100)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        LottieAnimation(

            composition = composition,
            progress = { logoAnimationState.progress }
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            navController.navigate(Screen.Home.route)
        }
    }
}