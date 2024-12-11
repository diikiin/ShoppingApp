package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.ShoppingCart
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingCartDao {

    @Query("select * from shopping_cart")
    fun getAll(): Flow<List<ShoppingCart>>

    @Query("select * from shopping_cart where cartId = :id")
    suspend fun getById(id: Int): ShoppingCart?

    @Query("select * from shopping_cart where userId = :userId")
    suspend fun getByUserId(userId: Int): ShoppingCart?

    @Insert
    suspend fun insert(shoppingCart: ShoppingCart)

    @Update
    suspend fun update(shoppingCart: ShoppingCart)

    @Delete
    suspend fun delete(shoppingCart: ShoppingCart)
    @Query("delete from shopping_cart where cartId = :id")
    suspend fun deleteById(id: Int)
}