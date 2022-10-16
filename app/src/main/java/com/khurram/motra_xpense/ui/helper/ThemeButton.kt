package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khurram.motra_xpense.ui.theme.buttonTrColor
import com.khurram.motra_xpense.ui.theme.themeColor

@Composable
fun BoldButton(btnText: String, doClick: Unit?) {
    Button(

        onClick = {
            //your onclick code here
            doClick
        },
        Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(15.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )) {
        Text(text = btnText)
    }
}

@Composable
fun TransparentButton(btnText: String, doClick: Unit?) {
    Button(

        onClick = {
            //your onclick code here
            doClick
        },
        Modifier.fillMaxWidth(),
        elevation=null,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonTrColor),
        contentPadding = PaddingValues(15.dp),
       ) {
        Text(text = btnText)
    }
}

@Preview
@Composable
fun tstButton() {
    TransparentButton(btnText = "khurram", doClick = null)
}