package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("select * from categories")
    fun getAll(): Flow<List<Category>>

    @Query("select * from categories where categoryId = :id")
    suspend fun getById(id: Long): Category?

    @Insert
    suspend fun insert(category: Category)

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Query("delete from categories where categoryId = :id")
    suspend fun deleteById(id: Long)
}