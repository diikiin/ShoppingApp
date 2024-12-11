package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.OrderItem
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderItemDao {

    @Query("select * from order_items")
    fun getAll(): Flow<List<OrderItem>>

    @Query("select * from order_items where orderItemId= :id")
    suspend fun getById(id: Int): OrderItem?

    @Insert
    suspend fun insert(orderItem: OrderItem)

    @Update
    suspend fun update(orderItem: OrderItem)

    @Delete
    suspend fun delete(orderItem: OrderItem)

    @Query("delete from order_items where orderItemId = :id")
    suspend fun deleteById(id: Int)
}