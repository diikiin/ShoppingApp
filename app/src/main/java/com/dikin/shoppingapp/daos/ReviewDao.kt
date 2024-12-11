package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {

    @Query("select * from reviews")
    fun getAll(): Flow<List<Review>>

    @Query("select * from reviews where reviewId = :id")
    suspend fun getById(id: Int): Review?

    @Insert
    suspend fun insert(review: Review)

    @Update
    suspend fun update(review: Review)

    @Delete
    suspend fun delete(review: Review)

    @Query("delete from reviews where reviewId = :id")
    suspend fun deleteById(id: Int)
}