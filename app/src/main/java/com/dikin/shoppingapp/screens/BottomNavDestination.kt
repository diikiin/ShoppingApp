package com.dikin.shoppingapp.screens

import com.dikin.shoppingapp.R

sealed class BottomNavDestination(val route: String, val label: String, val icon: Int) {
    data object Products : BottomNavDestination("products", "Products", R.drawable.products)
    data object Cart : BottomNavDestination("cart", "Cart", R.drawable.cart)
    data object Profile : BottomNavDestination("profile", "Profile", R.drawable.profile)
}