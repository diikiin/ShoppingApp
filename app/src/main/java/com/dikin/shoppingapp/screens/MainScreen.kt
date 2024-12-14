package com.dikin.shoppingapp.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.dikin.shoppingapp.entities.User
import com.dikin.shoppingapp.navigation.BottomNavigationGraph
import com.dikin.shoppingapp.navigation.BottomNavigationMenu
import com.dikin.shoppingapp.utils.ComposableLifecycle
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun MainScreen() {
    val tag = "Composable LifeCycle"
    ComposableLifecycle { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> Log.d(tag, "onCreate")
            Lifecycle.Event.ON_START -> Log.d(tag, "On Start")
            Lifecycle.Event.ON_RESUME -> Log.d(tag, "On Resume")
            Lifecycle.Event.ON_PAUSE -> Log.d(tag, "On Pause")
            Lifecycle.Event.ON_STOP -> Log.d(tag, "On Stop")
            Lifecycle.Event.ON_DESTROY -> Log.d(tag, "On Destroy")
            else -> {}
        }
    }

    val navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()

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
    }
    userViewModel.currentUser = currentUser

    Scaffold(
        bottomBar = { BottomNavigationMenu(navController = navController) },
    )
    { paddingValues ->
        BottomNavigationGraph(
            userViewModel = userViewModel,
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}