package com.dikin.shoppingapp.models

data class CartItemWithProduct(
    val cartItemId: Int,
    val cartId: Int,
    val productId: Int,
    val quantity: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: Double,
    val productImageUrl: String
)
