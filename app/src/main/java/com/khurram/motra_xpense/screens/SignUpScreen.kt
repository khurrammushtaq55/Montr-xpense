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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.helper.ThemeTextField


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
            Column(modifier = Modifier.fillMaxWidth().padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Spacer(modifier = Modifier.height(56.dp))
                ThemeTextField(textFieldValue = "", label = "Name")

                Spacer(modifier = Modifier.height(26.dp))
                ThemeTextField(textFieldValue = "", label = "Email")

                Spacer(modifier = Modifier.height(26.dp))
                ThemeTextField(textFieldValue = "", label = "Password", R.drawable.ic_show)
            }
        }


    )


}

@Composable
fun SignupView() {
    Column() {


        Spacer(modifier = Modifier.height(56.dp))
        ThemeTextField(textFieldValue = "", label = "Name")

        Spacer(modifier = Modifier.height(26.dp))
        ThemeTextField(textFieldValue = "", label = "Email")

        Spacer(modifier = Modifier.height(26.dp))
        ThemeTextField(textFieldValue = "", label = "Password", R.drawable.ic_show)
    }
}


@Preview
@Composable
fun test() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}



