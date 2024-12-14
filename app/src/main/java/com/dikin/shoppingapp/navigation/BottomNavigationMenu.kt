package com.dikin.shoppingapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationMenu(navController: NavController) {
    val items = listOf(
        BottomNavDestination.Products,
        BottomNavDestination.Cart,
        BottomNavDestination.Profile
    )

    NavigationBar {
        items.forEachIndexed { index, screen ->
            val backStackEntry = navController.currentBackStackEntryAsState()
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(screen.icon),
                        contentDescription = screen.label
                    )
                },
                label = { Text(screen.label) },
                selected = screen.route == backStackEntry.value?.destination?.route,
                onClick = {
                    navController.navigate(screen.route)
                }
            )
        }
    }
}
