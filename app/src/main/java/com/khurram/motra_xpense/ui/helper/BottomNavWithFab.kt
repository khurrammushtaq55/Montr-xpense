package com.khurram.motra_xpense.ui.helper

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.khurram.motra_xpense.navigation.bottomItems
import com.khurram.motra_xpense.routes.BottomScreens
import com.khurram.motra_xpense.ui.theme.Violet100

@Composable
fun BottomBarWithFabDem() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(65.dp)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                cutoutShape = CircleShape,
                //backgroundColor = Color.White,
                elevation = 22.dp
            ) {
                BottomNav(navController = navController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {
                    BottomScreens.Add.route?.let {
                        navController.navigate(it) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                    BottomScreens.Add.route?.let { navController.navigate(it) }
                },
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icon")
            }
        }
    ) {
        MainScreenNavigation(navController)
    }
}

@Composable
fun MainScreenNavigation(navController: NavHostController) {

    NavHost(navController, startDestination = BottomScreens.Home.route) {

        //profile
        composable(BottomScreens.Budget.route) {
            // ProfileScreen()
        }
        //pickUp
        composable(BottomScreens.Transaction.route) {
            // PickupScreen()
        }

        //camera
        composable(BottomScreens.Profile.route){
            // CameraScreen()
        }
    }


}

@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    BottomNavigation(
        modifier = Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp)
            .height(100.dp),
        //backgroundColor = Color.White,
        elevation = 0.dp
    ) {
      /*  bottomItems.forEach {
            BottomNavigationItem(
                icon = {
                    it.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = "",
                            modifier = Modifier.size(35.dp),
                            //tint = Color.Gray

                        )
                    }
                },
                label = {
                    it.title?.let {
                        Text(
                            text = it,
                            //color = Color.Gray
                        )
                    }
                },
                selected = currentRoute?.hierarchy?.any { it.route == it.route } == true,

                selectedContentColor = Violet100,
                unselectedContentColor = Color.White.copy(alpha = 0.4f),
                onClick = {
                    it.route?.let { it1 ->
                        navController.navigate(it1) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            )
        }*/
    }
}