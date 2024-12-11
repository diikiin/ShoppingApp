package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Query("select * from cart_items")
    fun getAll(): Flow<List<CartItem>>

    @Query("select * from cart_items where cartItemId = :id")
    suspend fun getById(id: Int): CartItem?

    @Insert
    suspend fun insert(cartItem: CartItem)

    @Update
    suspend fun update(cartItem: CartItem)

    @Delete
    suspend fun delete(cartItem: CartItem)
}