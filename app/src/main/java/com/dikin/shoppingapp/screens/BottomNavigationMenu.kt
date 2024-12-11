package com.dikin.shoppingapp.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import com.dikin.shoppingapp.R

@Composable
fun BottomNavigationMenu(navController: NavController) {
    val items = listOf(
        BottomNavDestination.Products,
        BottomNavDestination.Cart,
        BottomNavDestination.Profile
    )

//    var selectedTabIndex by rememberSaveable {
//        mutableStateOf(0)
//    }

    BottomAppBar {
//        items.forEach { index, destination ->
//            NavigationBarItem(
//                icon = { Icon(imageVector = (id = destination.icon), contentDescription = destination.label) },
//                label = { Text(destination.label) },
//                selected = navController.currentDestination?.route == index,
//                onClick = {
//                    selectedTabIndex = index
//                    navController.navigate(item.) }
//            )
//        }
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Products",
                )
            },
            label = { Text("Products") },
            selected = true,
            onClick = {/*TODO*/ }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "ShoppingCart",
                )
            },
            label = { Text("Shopping Cart") },
            selected = false,
            onClick = {/*TODO*/ }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Profile",
                )
            },
            label = { Text("Profile") },
            selected = false,
            onClick = {/*TODO*/ }
        )
    }
}