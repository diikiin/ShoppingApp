package com.dikin.shoppingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.dikin.shoppingapp.screens.Greeting
import com.dikin.shoppingapp.screens.MainScreen
import com.dikin.shoppingapp.screens.Sum
import com.dikin.shoppingapp.ui.theme.ShoppingAppTheme

class MainActivity : ComponentActivity() {

    val LIFECYCLE_TAG = "Activity Lifecycle"

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
                MainScreen()
            }
        }
        Log.i(LIFECYCLE_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(LIFECYCLE_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LIFECYCLE_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LIFECYCLE_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LIFECYCLE_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(LIFECYCLE_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LIFECYCLE_TAG, "onDestroy")
    }
}
