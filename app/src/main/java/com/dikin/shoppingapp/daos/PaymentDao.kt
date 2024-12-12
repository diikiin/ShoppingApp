package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {

    @Query("select * from payments")
    fun getAll(): Flow<List<Payment>>

    @Query("select * from payments where paymentId = :id")
    suspend fun getById(id: Long): Payment?

    @Insert
    suspend fun insert(payment: Payment)

    @Update
    suspend fun update(payment: Payment)

    @Delete
    suspend fun delete(payment: Payment)

    @Query("delete from payments where paymentId = :id")
    suspend fun deleteById(id: Long)
}