package com.dikin.shoppingapp.models

data class ProductWithCategory(
    val productId: Long,
    val name: String,
    val description: String?,
    val price: Double,
    val imageUrl: String?,
    val categoryId: Long,
    val categoryName: String
)