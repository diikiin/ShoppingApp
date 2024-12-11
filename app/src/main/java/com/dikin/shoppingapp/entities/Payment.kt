package com.dikin.shoppingapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "payments",
    foreignKeys = [
        ForeignKey(
            entity = Order::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Payment(
    @PrimaryKey(autoGenerate = true)
    val paymentId: Int = 0,
    val orderId: Int,
    val amount: Double,
    val paymentDate: String,
    val paymentMethod: String
)