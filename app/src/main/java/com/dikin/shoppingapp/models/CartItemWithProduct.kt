package com.dikin.shoppingapp.models

data class CartItemWithProduct(
    val cartItemId: Long,
    val cartId: Long,
    val productId: Long,
    val quantity: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: Double,
    val productImageUrl: String?
)
