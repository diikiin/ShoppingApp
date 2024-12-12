package com.dikin.shoppingapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

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
                    selectedIndex = index
                    navController.navigate(screen.route)
                }
            )
        }
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
//        0 -> ProductsCatalogScreen()
//        1 -> ShoppingCartScreen()
//        2 -> UserProfileScreen()
    }
}