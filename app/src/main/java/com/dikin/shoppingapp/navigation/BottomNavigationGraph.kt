package com.dikin.shoppingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dikin.shoppingapp.screens.UserProfileScreen
import com.dikin.shoppingapp.screens.products.ProductsCatalogScreen
import com.dikin.shoppingapp.screens.shopping_cart.ShoppingCartScreen
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun BottomNavigationGraph(
    userViewModel: UserViewModel,
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavDestination.Products.route
    ) {
        composable(route = BottomNavDestination.Products.route) {
            ProductsCatalogScreen(userViewModel = userViewModel, modifier = modifier)
        }
        composable(route = BottomNavDestination.Cart.route) {
            ShoppingCartScreen(userViewModel = userViewModel, modifier = modifier)
        }
        composable(route = BottomNavDestination.Profile.route) {
            UserProfileScreen(userViewModel = userViewModel, modifier = modifier)
        }
    }
}