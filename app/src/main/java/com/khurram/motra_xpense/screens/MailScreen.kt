package com.khurram.motra_xpense.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.helper.BoldButton


@Composable
fun MailScreen(navController: NavHostController) {

    Column(

        ) {

        
        Column(Modifier.weight(1f)) {


            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_mail_view),
                contentDescription = "Ilustration",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(30.dp))


            Text(
                text = "Your email is on the way",
                color = Color(0xff0d0e0f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )


            Text(
                text = "Check your email test@test.com and follow the instructions to reset your password",
                color = Color(0xff292b2d),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )

        }

        Box(modifier = Modifier.padding(20.dp)) {
            BoldButton(btnText = "Back to Login") {
            }
        }
    }



}

@Preview
@Composable
fun abc() {
    val navController = rememberNavController()
    MailScreen(navController = navController)
}