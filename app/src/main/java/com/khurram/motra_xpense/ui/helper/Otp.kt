/*
package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.khurram.motra_xpense.R


class OTP() {
    @Composable
    fun PinInput(
        modifier: Modifier = Modifier,
        length: Int = 5,
        value: String = "",
    ) {

        var maxDigits: Int = 6
        var attemps by remember { mutableStateOf(0) }
        var pin by remember { mutableStateOf("") }
        var color by remember { mutableStateOf(Color.Blue) }

        Box(contentAlignment = Alignment.Center) {
            Box(
                Modifier
                    .size(100.dp)
            )
            {
                Row() {
                    repeat(maxDigits) {
                        getView(it, pin, color)
                    }
                }
            }

            Box(
                Modifier
                    .size(100.dp)
            )
            {

                TextField(
                    value = pin,
                    onValueChange = {
                        if (pin.count() > maxDigits) {
                            pin = (pin.substring(0, maxDigits))
                        } else if (pin.count() == maxDigits) {
                            validate(pin, value, color)
                        } else {
                            color = Color.White
                        }

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ), modifier = Modifier.
                )
            }
        }
    }

    @Composable
    fun getView(index: Int, pin: String, colorr: Color) {

        if (index >= pin.count()) {
            Image(
                painter = painterResource(id = R.drawable.ic_pininput),
                contentDescription = "dot",
            )
        } else {
            Text(text = pin[index].toString(), fontSize = 15.sp, color = colorr)
        }

    }

    private fun validate(pin: String, validPin: String, color: Color) {
        */
/*  if (pin != validPin) {
              color = Color.Red
          } else {
              color = Color.Green
          }*//*

    }



    @Preview
    @Composable
    fun tstOTP() {

        PinInput()
    }

}

*/
