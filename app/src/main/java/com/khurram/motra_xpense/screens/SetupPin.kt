package com.khurram.motra_xpense.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.helper.BoldButton
import com.khurram.motra_xpense.ui.helper.PinInputWidget
import com.khurram.motra_xpense.ui.helper.ThemeTextField
import com.khurram.motra_xpense.ui.theme.Violet100


@Composable
fun SetupPin(navController: NavHostController) {


    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Violet100),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(36.dp))

                Text(
                    text = "Let’s  setup your PIN",
                    color = Color(0xfffcfcfc),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )


                Spacer(modifier = Modifier.height(36.dp))

                PinInputWidget(4)


            }
        })
}


@Preview
@Composable
fun tessast() {
    val navController = rememberNavController()
    SetupPin(navController = navController)
}



