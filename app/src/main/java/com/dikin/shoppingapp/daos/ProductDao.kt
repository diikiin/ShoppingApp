package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getAll(): Flow<List<Product>>

    @Query("select * from products where productId = :id")
    suspend fun getById(id: Int): Product?

    @Insert
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("delete from products where productId = :id")
    suspend fun deleteById(id: Int)
}