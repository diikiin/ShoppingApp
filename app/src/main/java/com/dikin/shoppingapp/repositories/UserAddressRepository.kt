package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.UserAddressDao
import com.dikin.shoppingapp.entities.UserAddress
import kotlinx.coroutines.flow.Flow

class UserAddressRepository(private val dao: UserAddressDao) {
    val all: Flow<List<UserAddress>> = dao.getAll()

    suspend fun getById(id: Int): UserAddress? {
        return dao.getById(id)
    }

    suspend fun create(userAddress: UserAddress) {
        dao.insert(userAddress)
    }

    suspend fun update(userAddress: UserAddress) {
        dao.update(userAddress)
    }

    suspend fun delete(userAddress: UserAddress) {
        dao.delete(userAddress)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}