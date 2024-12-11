package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Query("select * from orders")
    fun getAll(): Flow<List<Order>>

    @Query("select * from orders where orderId = :id")
    suspend fun getById(id: Int): Order?

    @Insert
    suspend fun insert(order: Order)

    @Update
    suspend fun update(order: Order)

    @Delete
    suspend fun delete(order: Order)

    @Query("delete from orders where orderId = :id")
    suspend fun deleteById(id: Int)
}