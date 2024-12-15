package com.dikin.shoppingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dikin.shoppingapp.screens.comments.CommentsSection
import com.dikin.shoppingapp.screens.products.ProductsCatalogScreen
import com.dikin.shoppingapp.screens.shopping_cart.ShoppingCartScreen
import com.dikin.shoppingapp.screens.user.UserProfileScreen
import com.dikin.shoppingapp.screens.websocket.WebSocketScreen
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
            ProductsCatalogScreen(
                navController = navController,
                userViewModel = userViewModel,
                modifier = modifier
            )
        }
        composable(route = BottomNavDestination.Cart.route) {
            ShoppingCartScreen(userViewModel = userViewModel, modifier = modifier)
        }
        composable(route = BottomNavDestination.Profile.route) {
            UserProfileScreen(
                userViewModel = userViewModel,
                modifier = modifier,
                onNavigateToWebSocket = { navController.navigate("webSocket") }
            )
        }
        composable(route = "commentsSection") {
            CommentsSection(modifier = modifier)
        }
        composable(route = "webSocket") {
            WebSocketScreen(modifier = modifier)
        }
    }
}