package com.dikin.shoppingapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "shopping_cart",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ShoppingCart(
    @PrimaryKey(autoGenerate = true)
    val cartId: Int = 0,
    val userId: Int
)
