package com.dikin.shoppingapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.time.Instant
import java.util.Date

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
    @PrimaryKey
    val cartId: Int = 0,
    val userId: Int,
    val createdAt: Date = Timestamp.from(Instant.now())
)
