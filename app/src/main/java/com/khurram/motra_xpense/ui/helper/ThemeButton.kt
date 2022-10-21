package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khurram.motra_xpense.R

@Composable
fun BoldButton(btnText: String, doClick:()-> Unit) {
    Button(
        onClick = doClick,
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff7f3dff)),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp)
//            .padding(all = 10.dp)
    ) {
        Text(
            text = btnText,
            color = Color(0xfffcfcfc),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp))
    }
}

@Composable
fun TransparentButton(btnText: String, doClick:()-> Unit) {
    Button(
        onClick = doClick,
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffeee5ff)),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 70.dp)
            .padding(all = 10.dp)
    ) {
        Text(
            text = btnText,
            color = Color(0xff7f3dff),
            style = TextStyle(
                fontSize = 18.sp)
        )
    }

}


@Composable
fun GoogleButton(btnText: String, doClick:()-> Unit) {
    Button(

        onClick = doClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        border = BorderStroke(1.dp, Color(0xfff1f1fa)),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 70.dp)
            .padding(all = 8.dp)
    ) {
        Image(
            painterResource(id = R.drawable.ic_google),
            contentDescription = "drawable icons",
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = btnText,
            color = Color(0xff212325),
            style = TextStyle(
                fontSize = 18.sp))
    }

}
