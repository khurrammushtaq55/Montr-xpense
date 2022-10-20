package com.khurram.motra_xpense.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.routes.Screens
import com.khurram.motra_xpense.ui.helper.BoldButton
import com.khurram.motra_xpense.ui.helper.DotsIndicator
import com.khurram.motra_xpense.ui.helper.HorizontalPagerContent
import com.khurram.motra_xpense.ui.helper.TransparentButton
import com.khurram.motra_xpense.ui.theme.Violet100


@Composable
fun HomeScreen(navController: NavHostController) {


    HorizontalPagerScreen(navController)
    Spacer(modifier = Modifier.padding(4.dp))


}

fun createItems() = listOf(
    HorizontalPagerContent(
        image = R.drawable.ic_logo1, title = "Gain total control of your money",
        subtitle = "Become your own money manager and make every cent count"
    ),
    HorizontalPagerContent(
        image = R.drawable.ic_logo2, title = "Know where your money goes",
        subtitle = "Track your transaction easily, with categories and financial report "
    ),
    HorizontalPagerContent(
        image = R.drawable.ic_logo3, title = "Planning ahead",
        subtitle = "Setup your budget for each category so you in control"
    ),
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .wrapContentSize()
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = items.size,
            state = pagerState,

            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(screenHeight / 2)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painterResource(items[currentPage].image),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].title,
                    Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h4, textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].subtitle,
                    Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.body2, textAlign = TextAlign.Center
                )
            }
        }


        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            DotsIndicator(
                totalDots = 3,
                selectedIndex = pagerState.currentPage,
                selectedColor = Violet100,
                unSelectedColor = Color.LightGray,
            )
        }

        Column(Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.height(40.dp))
            BoldButton("Sign Up"){navController.navigate(Screens.Mail.route)}
            Spacer(modifier = Modifier.height(10.dp))
            TransparentButton("Log In", ){}
            Spacer(modifier = Modifier.height(30.dp))
        }


    }


}



