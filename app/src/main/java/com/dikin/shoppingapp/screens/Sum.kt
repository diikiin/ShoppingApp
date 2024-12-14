package com.dikin.shoppingapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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