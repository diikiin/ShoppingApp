package com.dikin.shoppingapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.entities.User
import com.dikin.shoppingapp.screens.ProductsCatalogScreen
import com.dikin.shoppingapp.screens.ShoppingCartScreen
import com.dikin.shoppingapp.screens.UserProfileScreen
import com.dikin.shoppingapp.ui.theme.ShoppingAppTheme
import com.dikin.shoppingapp.viewmodels.ShoppingCartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Column(modifier = Modifier.padding(innerPadding)) {
//                        Greeting(
//                            name = "World!",
//                            modifier = Modifier
//                                .fillMaxWidth()
//                        )
//                        Sum(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                        )
//                    }
//                }
                MainApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Sum(modifier: Modifier = Modifier) {
    val add: (Int, Int) -> Int = { a, b -> a + b }
    val sum = add(10, 33)

    val square: (Int) -> Int = { it * it }
    val squareOfInt = square(5)

    Text(
        text = "Sum of integers: $sum\nSquare of 5: $squareOfInt",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingAppTheme {
        Greeting("Android")
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val user =
        remember { User(username = "amigo", email = "amigo@email.com", passwordHash = "hash") }
    val application = LocalContext.current.applicationContext as Application

    NavHost(navController = navController, startDestination = "productsCatalog") {
        composable("productsCatalog") {
            ProductsCatalogScreen()
        }
        composable("shoppingCart") {
            ShoppingCartScreen(userId = user.userId)
        }
        composable("userProfileScreen") {
            UserProfileScreen(user)
        }
    }
}