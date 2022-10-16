package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.ui.theme.MotraxpenseTheme
import com.khurram.motra_xpense.ui.theme.themeColor

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {

    LazyRow(

        modifier = Modifier
            .wrapContentWidth()
            .height(20.dp)

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Column() {
                    Box(
                        modifier = Modifier
                            .size(11.dp)
                            .clip(RectangleShape)
                            .background(selectedColor)
                    )
                }
            } else {
                Column(
                    )  {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(unSelectedColor)
                    )
                }
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MotraxpenseTheme {
        val navController = rememberNavController()
//        setNavGraph(navController = navController)
//        HomeScreen(navController = navController)
        DotsIndicator(
            totalDots = 7, selectedIndex = 1, selectedColor = themeColor,
            unSelectedColor = Color.Gray
        )
    }

}