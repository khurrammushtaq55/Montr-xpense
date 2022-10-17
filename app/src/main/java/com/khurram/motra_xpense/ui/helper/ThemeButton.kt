package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khurram.motra_xpense.R
import com.khurram.motra_xpense.ui.theme.buttonThemeTrColor
import com.khurram.motra_xpense.ui.theme.buttonTrColor

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
        )
    ) {
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
        elevation = null,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonThemeTrColor),
        contentPadding = PaddingValues(15.dp),
    ) {
        Text(text = btnText)
    }
}


@Composable
fun GoogleButton(btnText: String, doClick: Unit?) {
    Button(

        onClick = {
            //your onclick code here
            doClick
        },
        Modifier.fillMaxWidth(),
        elevation = null,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonTrColor),
        contentPadding = PaddingValues(15.dp),
    ) {
        Icon(
            painterResource(id = R.drawable.ic_google),
            modifier = Modifier
                .size(18.dp),
            contentDescription = "drawable icons",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = btnText)
    }
}

@Preview
@Composable
fun tstButton() {
    GoogleButton(btnText = "Sign Up with google", doClick = null)
}