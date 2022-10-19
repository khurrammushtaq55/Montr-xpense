package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.theme.Green100

@Composable
fun IncomeExpenseBox(type:String,amount:String,bgColor:Color,drawable:Int) {


    Card(
        modifier = Modifier
            .width(165.dp).wrapContentHeight()
            , shape = CircleShape.copy(CornerSize(28.dp))

    ) {
        Row(

            modifier = Modifier
                .background(color = bgColor)

        ) {


            Image(
                painter = painterResource(id = drawable),
                contentDescription = "",
                Modifier.padding(17.dp)
            )

            Column(Modifier.padding(vertical = 17.dp)) {


                Text(
                    text = type,
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    text = amount,
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 22.sp
                    )
                )
            }
        }
    }

}

@Preview
@Composable
fun test() {
//    IncomeExpenseBox()
}