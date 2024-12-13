package com.dikin.shoppingapp.models

import androidx.lifecycle.LiveData

data class CartWithItems(
    val cartId: Long,
    val userId: Long,
    val items: LiveData<List<CartItemWithProduct>>
)