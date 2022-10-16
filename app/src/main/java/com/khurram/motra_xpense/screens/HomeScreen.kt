package com.khurram.motra_xpense.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.helper.BoldButton
import com.khurram.motra_xpense.ui.helper.DotsIndicator
import com.khurram.motra_xpense.ui.helper.HorizontalPagerContent
import com.khurram.motra_xpense.ui.helper.TransparentButton


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    HorizontalPagerScreen()
    Spacer(modifier = Modifier.padding(4.dp))


}

fun createItems() = listOf(
    HorizontalPagerContent(
        image = R.drawable.ic_launcher_foreground, title = "Gain total control of your money",
        subtitle = "Become your own money manager and make every cent count"
    ),
    HorizontalPagerContent(
        image = R.drawable.ic_launcher_foreground, title = "Know where your money goes",
        subtitle = "Track your transaction easily, with categories and financial report "
    ),
    HorizontalPagerContent(
        image = R.drawable.ic_launcher_foreground, title = "Planning ahead",
        subtitle = "Setup your budget for each category so you in control"
    ),
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                /* Icon(imageVector = ImageVector(),""
                 )*/
                Spacer(modifier = Modifier.height(screenHeight / 2))
                Text(
                    text = items[currentPage].title,
                    style = MaterialTheme.typography.h4, textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].subtitle,
                    style = MaterialTheme.typography.body2, textAlign = TextAlign.Center
                )
            }
        }


        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            DotsIndicator(
                totalDots = 3,
                selectedIndex = pagerState.currentPage,
                selectedColor = Color.Blue,
                unSelectedColor = Color.Red,
            )
        }
        val coroutineScope = rememberCoroutineScope()
        Spacer(modifier = Modifier.height(10.dp))
        BoldButton("Sign Up", null)
        TransparentButton("Log In", null)
    }
}


