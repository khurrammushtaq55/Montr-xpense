package com.khurram.motra_xpense.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.helper.BoldButton
import com.khurram.motra_xpense.ui.helper.GoogleButton
import com.khurram.motra_xpense.ui.helper.ThemeTextField
import com.khurram.motra_xpense.ui.theme.Violet100


@Composable
fun SignUpScreen(navController: NavHostController) {


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        text = "SignUp",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Spacer(modifier = Modifier.height(56.dp))
                ThemeTextField(textFieldValue = "", label = "Name")

                Spacer(modifier = Modifier.height(26.dp))
                ThemeTextField(textFieldValue = "", label = "Email")

                Spacer(modifier = Modifier.height(26.dp))
                ThemeTextField(textFieldValue = "", label = "Password", R.drawable.ic_show)
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    val checkedState = remember { mutableStateOf(true) }
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            checkedColor = Violet100,
                            uncheckedColor = Violet100
                        ),
                    )

                    Text(
                        lineHeight = 18.sp,
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            ) { append("By signing up, you agree to the ") }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xff7f3dff),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            ) { append("Terms of Service and Privacy Policy") }
                        })

                }

                Spacer(modifier = Modifier.height(10.dp))
                BoldButton(btnText = "Sign Up") {

                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Or with",
                    color = Color(0xff91919f),
                    lineHeight = 18.sp,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))

                GoogleButton(btnText = "SignUp With Google") {

                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff91919f),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        ) { append("Already have an account? ") }
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff7f3dff),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        ) { append("Login") }
                    })
            }
        }


    )


}


@Preview
@Composable
fun test() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}



