package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.UserDao
import com.dikin.shoppingapp.entities.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val dao: UserDao) {
    val all: Flow<List<User>> = dao.getAll()

    suspend fun getById(id: Int): User? {
        return dao.getById(id)
    }

    fun getByUsername(username: String): User? {
        return dao.getByUsername(username)
    }

    suspend fun create(user: User) {
        dao.insert(user)
    }

    suspend fun update(user: User) {
        dao.update(user)
    }

    suspend fun delete(user: User) {
        dao.delete(user)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}