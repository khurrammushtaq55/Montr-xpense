package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
    fun PinInputWidget(charLimit:Int = 4) {
        val focusManager = LocalFocusManager.current
        val (text, setText) = remember {
            mutableStateOf(TextFieldValue(""))
        }

        LaunchedEffect(
            key1 = text,
        ) {
            if (text.text.length == charLimit) {
                focusManager.clearFocus()
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .width(
                        200.dp,
                    ),
            ) {
                CompositionLocalProvider(
                ) {
                    BasicTextField(
                        value = text,
                        onValueChange = { newValue ->
                            if (newValue.text.length <= charLimit) {
                                setText(
                                    if (newValue.selection.length > 0) {
                                        newValue.copy(
                                            selection = text.selection,
                                        )
                                    } else {
                                        newValue
                                    }
                                )
                            }
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.NumberPassword,
                            imeAction = ImeAction.Done,
                        ),
                        textStyle = TextStyle(
                            color = Transparent,
                        ),
                        cursorBrush = SolidColor(Transparent),
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxWidth()
                            .padding(16.dp),
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    for (i in 0 until charLimit) {
                        if (i < text.text.length) {
                            Dot(White)
                        } else {
                            Dot(LightGray)
                        }
                    }
                }
            }

        }
    }

    // This can be replaced with any composable as per requirement.
    @Composable
    fun Dot(
        color: Color,
    ) {
        Box(
            modifier = Modifier
                .requiredSize(
                    size = 32.dp,
                )
                .background(
                    color = color,
                    shape = CircleShape,
                ),
        )
    }



@Preview
@Composable
fun abc()
{
    PinInputWidget(4)
}