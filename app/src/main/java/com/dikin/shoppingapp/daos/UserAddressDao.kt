package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.UserAddress
import kotlinx.coroutines.flow.Flow

@Dao
interface UserAddressDao {

    @Query("select * from user_addresses")
    fun getAll(): Flow<List<UserAddress>>

    @Query("select * from user_addresses where addressId = :id")
    suspend fun getById(id: Int): UserAddress?

    @Insert
    suspend fun insert(userAddress: UserAddress)

    @Update
    suspend fun update(userAddress: UserAddress)

    @Delete
    suspend fun delete(userAddress: UserAddress)
}