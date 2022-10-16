package com.khurram.motra_xpense.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.khurram.motra_xpense.ui.helper.BoldButton
import com.khurram.motra_xpense.ui.helper.DotsIndicator
import com.khurram.motra_xpense.ui.helper.HorizontalPagerContent
import com.khurram.motra_xpense.ui.helper.TransparentButton
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    HorizontalPagerScreen()
    Spacer(modifier = Modifier.padding(4.dp))


}

fun createItems() = listOf(
    HorizontalPagerContent(title = "Title1", subtitle = "Subtitle1", description = "Description1"),
    HorizontalPagerContent(title = "Title2", subtitle = "Subtitle2", description = "Description2"),
    HorizontalPagerContent(title = "Title3", subtitle = "Subtitle3", description = "Description3"),
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = items[currentPage].title,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].subtitle,
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].description,
                    style = MaterialTheme.typography.body1
                )
            }
        }

        DotsIndicator(
            totalDots = 3,
            selectedIndex = pagerState.currentPage,
            selectedColor = Color.Blue,
            unSelectedColor = Color.Red
        )
        val coroutineScope = rememberCoroutineScope()
        BoldButton("Sign Up",null)
        TransparentButton("Log In",null)
    }
}


