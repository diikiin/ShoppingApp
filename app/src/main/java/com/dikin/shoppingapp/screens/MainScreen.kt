package com.dikin.shoppingapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.entities.User
import com.dikin.shoppingapp.navigation.BottomNavigationGraph
import com.dikin.shoppingapp.navigation.BottomNavigationMenu
import com.dikin.shoppingapp.viewmodels.ShoppingCartViewModel
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()
    val shoppingCartViewModel: ShoppingCartViewModel = viewModel()

    var currentUser = userViewModel.getByUsername("amigo")
    if (currentUser == null) {
        userViewModel.create(
            User(
                username = "amigo",
                email = "amigo@email.com",
                passwordHash = "hash"
            )
        )
        currentUser = userViewModel.getByUsername("amigo")
        currentUser?.let { shoppingCartViewModel.create(ShoppingCart(userId = it.userId)) }
    }
    userViewModel.currentUser = currentUser

    Scaffold(
        bottomBar = { BottomNavigationMenu(navController = navController) },
    )
    { paddingValues ->
        BottomNavigationGraph(
            userViewModel = userViewModel,
            navController = navController,
            paddingModifier = Modifier.padding(paddingValues)
        )
    }
}