package com.dikin.shoppingapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_addresses",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserAddress(
    @PrimaryKey(autoGenerate = true)
    val addressId: Long = 0,
    val userId: Long,
    val street: String?,
    val city: String?,
    val state: String?,
    val zipCode: String?
)
