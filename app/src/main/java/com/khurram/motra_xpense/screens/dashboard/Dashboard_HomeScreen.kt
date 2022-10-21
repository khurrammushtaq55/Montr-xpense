package com.khurram.motra_xpense.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.data.DataPoints
import com.khurram.motra_xpense.ui.helper.CubicChart
import com.khurram.motra_xpense.ui.helper.IncomeExpenseBox
import com.khurram.motra_xpense.ui.helper.SampleLineGraph
import com.khurram.motra_xpense.ui.theme.Dark100
import com.khurram.motra_xpense.ui.theme.Green100
import com.khurram.motra_xpense.ui.theme.Red100

@Composable
fun DashboardHome() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.White)
    ) {

        Text(
            text = "Account Balance",
            color = Color(0xff91919f),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )


        Text(
            text = "$9400",
            color = Color(0xff161719),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 40.sp
            ),
            modifier = Modifier
                .width(width = 328.dp)
        )

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {

            IncomeExpenseBox(
                type = "Income",
                amount = "$5000",
                bgColor = Green100,
                drawable = R.drawable.ic_income
            )

            IncomeExpenseBox(
                type = "Expense",
                amount = "$6000",
                bgColor = Red100,
                drawable = R.drawable.ic_expense
            )
        }
        Text(
            text = "Spend Frequency",
            color = Dark100,
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(all = 8.dp)
        )


//        SampleLineGraph(lines = listOf(DataPoints.dataPoints))

        CubicChart()

    }
}

@Preview
@Composable
fun gg() {
    DashboardHome()
}