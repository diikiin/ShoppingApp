package com.dikin.shoppingapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "orders",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Long = 0,
    val userId: Long,
    val orderDate: String = LocalDate.now().toString(),
    val totalAmount: Double,
    val status: String = "Created"
)
