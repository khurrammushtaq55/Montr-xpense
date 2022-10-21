package com.khurram.motra_xpense.ui.helper

import android.view.WindowMetrics
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.window.layout.WindowLayoutInfo
import kotlinx.coroutines.launch
import java.util.*


@Composable
fun Content(
    layoutInfo: WindowLayoutInfo?,
    windowMetrics: WindowMetrics,
    paddingValues: PaddingValues
) {
    val input = rememberSaveable { mutableStateOf("") }
    val output = rememberSaveable { mutableStateOf("") }
    val result = rememberSaveable { mutableStateOf(0) }
    val lastOp = rememberSaveable { mutableStateOf("") }
    val state = rememberScrollState()
    val scope = rememberCoroutineScope()
    val callback = { text: String ->
        handleButtonClick(text, input, output, lastOp, result)
        scope.launch {
            state.animateScrollTo(state.maxValue)
        }
    }
    val hingeDef = createHingeDef(layoutInfo, windowMetrics)
    val largeScreen = windowWidthDp(windowMetrics) >= 600.dp
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .background(color = MaterialTheme.colorScheme.tertiaryContainer),
        contentAlignment = if (hingeDef.hasGap and largeScreen)
            Alignment.TopStart
        else
            Alignment.Center
    ) {
        val width = min(
            maxWidth, if (hingeDef.hasGap)
                hingeDef.sizeLeft
            else
                600.dp
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .width(width)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1.0F)
                ) {
                    TimeInput(input.value)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = output.value,
                        color = MaterialTheme.colorScheme.primary,
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .weight(1.0f)
                            .verticalScroll(state = state),
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.surfaceVariant)
                        .padding(16.dp)

                ) {
                    NumKeypadRow(
                        listOf("7", "8", "9", "CE"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    NumKeypadRow(
                        listOf("4", "5", "6", "-"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    NumKeypadRow(
                        listOf("1", "2", "3", "+"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    NumKeypadRow(
                        listOf("0", ":", "="),
                        listOf(0.5f, 0.25f, 0.25f),
                        callback
                    )
                }
            }
            Spacer(modifier = Modifier.width(hingeDef.widthGap))
            Column(
                modifier = Modifier
                    .width(hingeDef.sizeRight)
                    .fillMaxHeight()
                    .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = R.string.info1))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.info2))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.info3))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.info4))
            }
        }
    }
}

@Composable
fun TimeInput(t: String) {
    val showHint = t.isEmpty()
    Text(
        text = if (showHint)
            stringResource(id = R.string.input_hint)
        else
            t,
        color = if (showHint)
            MaterialTheme.colorScheme.onSurface
        else
            MaterialTheme.colorScheme.secondary,
        style = MaterialTheme.typography.b1
    )
}

@Composable
fun NumKeypadRow(
    texts: List<String>,
    weights: List<Float>,
    callback: (text: String) -> Any
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in texts.indices) {
            MyButton(
                text = texts[i],
                modifier = Modifier.weight(weights[i]),
                callback = callback
            )
        }
    }
}

@Composable
fun MyButton(
    text: String,
    callback: (text: String) -> Any,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .padding(4.dp),
        onClick = {
            callback(text)
        }
    ) {
        Text(text)
    }
}

fun handleButtonClick(
    txt: String,
    inputTextView: MutableState<String>,
    outputTextView: MutableState<String>,
    lastOp: MutableState<String>,
    result: MutableState<Int>
) {
    when (txt) {
        "CE" -> if (inputTextView.value.isNotEmpty()) {
            inputTextView.value = ""
        } else {
            result.value = 0
            lastOp.value = "+"
            outputTextView.value = ""
        }
        "+", "-", "=" -> handleInput(inputTextView, outputTextView, txt, lastOp, result)
        ":" -> inputTextView.value += txt
        else -> inputTextView.value += txt
    }
}

private fun handleInput(
    inputTextView: MutableState<String>,
    outputTextView: MutableState<String>,
    op: String,
    lastOp: MutableState<String>,
    result: MutableState<Int>
) {
    var line = inputTextView.value
    if (!line.contains(":")) {
        if (line.length == 4) {
            line = line.substring(0, 2) + ":" + line.substring(2)
        } else {
            var total = 0
            if (line.isNotEmpty()) {
                total = getIntFromString(line)
            }
            val hours = total / 60
            val minutes = total % 60
            // trim() is important because we further process the result
            line = getTimeAsString(hours, minutes).trim { it <= ' ' }
        }
    }
    val pos = line.indexOf(':')
    var hours = getIntFromString(line.substring(0, pos))
    var minutes = getIntFromString(line.substring(pos + 1))
    var total = hours * 60 + minutes
    if ("-" == lastOp.value) {
        total = -total
    }
    lastOp.value = op
    result.value += total
    if (outputTextView.value.isNotEmpty()) {
        outputTextView.value += "\n"
    }
    outputTextView.value += "${getTimeAsString(hours, minutes)} $op"
    if ("=" == op) {
        val temp: Int = if (result.value < 0) -result.value else result.value
        hours = temp / 60
        minutes = temp % 60
        val strResult = getTimeAsString(hours, minutes).trim { it <= ' ' }
        outputTextView.value += " ${if (result.value < 0) "-" else ""}${strResult}\n"
        result.value = 0
        inputTextView.value = strResult
    } else {
        inputTextView.value = ""
    }
}

private fun getTimeAsString(hours: Int, minutes: Int): String {
    return String.format(Locale.US, "%3d:%02d", hours, minutes)
}

private fun getIntFromString(s: String): Int {
    return try {
        s.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}