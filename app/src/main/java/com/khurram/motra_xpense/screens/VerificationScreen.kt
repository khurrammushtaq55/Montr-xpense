package com.khurram.motra_xpense.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.ui.helper.BoldButton


@Composable
fun VerificationScreen(navController: NavHostController) {


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        text = "Verification",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp)

                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "as",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        },
        content = {
            Column(
                Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Enter your Verification Code",
                    color = Color(0xff0d0e0f),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .width(width = 343.dp)
                )

                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "04:59",
                    color = Color(0xff7f3dff),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff292b2d),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        ) { append("We send verification code to your email ") }
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff7f3dff),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        ) { append("brajaoma*****@gmail.com") }
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff212325),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        ) { append(". You can check your inbox.") }
                    })

                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "I didn’t received the code? Send again",
                    color = Color(0xff7f3dff),
                    textDecoration = TextDecoration.Underline,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Spacer(modifier = Modifier.height(35.dp))
                BoldButton(btnText = "Verify") {

                }
            }

        })


}

@Preview
@Composable
fun ass() {
    val navController = rememberNavController()
    VerificationScreen(navController = navController)
}



