package com.khurram.motra_xpense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.navigation.setNavGraph
import com.khurram.motra_xpense.ui.theme.MotraxpenseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotraxpenseTheme() {
                val navController = rememberNavController()
                setNavGraph(navController = navController)

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MotraxpenseTheme {
    }
}