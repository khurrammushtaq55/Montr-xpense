package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khurram.motra_xpense.ui.theme.borderColor

@Composable
fun ThemeTextField(textFieldValue: String, label: String, drawable: Int? = null) {

    val mutableState = remember {
        mutableStateOf(textFieldValue)
    }

    TextField(
        value = mutableState.value,
        label = { Text(label) },
        trailingIcon = {
            if (drawable != null) Icon(
                painter = painterResource(id = drawable),
                contentDescription = "cd"
            )
        },
        onValueChange = { newValue ->
            mutableState.value = newValue
        },
        modifier = Modifier
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        )
    )
}

@Preview
@Composable
fun acac() {
    ThemeTextField("", "Enter Name")
}
