package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("select * from users")
    fun getAll(): Flow<List<User>>

    @Query("select * from users where userId = :id")
    suspend fun getById(id: Int): User?

    @Query("select * from users where username = :username")
    fun getByUsername(username: String): User?

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("delete from users where userId = :id")
    suspend fun deleteById(id: Int)
}