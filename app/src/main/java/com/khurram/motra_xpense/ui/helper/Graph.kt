package com.khurram.motra_xpense.ui.helper


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khurram.motra_xpense.ui.theme.Red100
import com.khurram.motra_xpense.ui.theme.Violet100
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot

@Composable
fun CubicChart(
    modifier: Modifier = Modifier,
    yPoints: List<Float> = listOf(
        199f, 52f, 193f, 290f, 150f, 445f,65f,45f,45f,45f,
    ),
    graphColor: Color = Violet100
) {

    val spacing = 0f
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .background(Color.White)
    ) {

        androidx.compose.foundation.Canvas(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {

            val spacePerHour = (size.width - spacing) / yPoints.size

            val normX = mutableListOf<Float>()
            val normY = mutableListOf<Float>()

            val strokePath = Path().apply {

                for (i in yPoints.indices) {

                    val currentX = spacing + i * spacePerHour

                    if (i == 0) {

                        moveTo(currentX, yPoints[i])
                    } else {

                        val previousX = spacing + (i - 1) * spacePerHour

                        val conX1 = (previousX + currentX) / 2f
                        val conX2 = (previousX + currentX) / 2f

                        val conY1 = yPoints[i - 1]
                        val conY2 = yPoints[i]


                        cubicTo(
                            x1 = conX1,
                            y1 = conY1,
                            x2 = conX2,
                            y2 = conY2,
                            x3 = currentX,
                            y3 = yPoints[i]
                        )
                    }

                    // Circle dot points
//                    normX.add(currentX)
//                    normY.add(yPoints[i])

                }
            }


            drawPath(
                path = strokePath,
                color = graphColor,
                style = Stroke(
                    width = 4.dp.toPx(),
                    cap = StrokeCap.Round,

                )
            )

            (normX.indices).forEach {
                drawCircle(
                    Color.Black,
                    radius = 3.dp.toPx(),
                    center = Offset(normX[it], normY[it])
                )
            }
        }
    }
}

@Preview
@Composable
fun vv() {
    CubicChart()
}

@Composable
fun SampleLineGraph(lines: List<List<DataPoint>>) {
    LineGraph(
        plot = LinePlot(
            listOf(
                LinePlot.Line(
                    lines[0],
                    LinePlot.Connection(color = Red100),
                    null,
                    null,
                )
            ),

            ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        onSelection = { xLine, points ->
            // Do whatever you want here
        }
    )
}