package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.ShoppingCartDao
import com.dikin.shoppingapp.entities.ShoppingCart
import kotlinx.coroutines.flow.Flow

class ShoppingCartRepository(private val dao: ShoppingCartDao) {
    val all: Flow<List<ShoppingCart>> = dao.getAll()

    suspend fun getById(id: Int): ShoppingCart? {
        return dao.getById(id)
    }

    suspend fun getByUserId(userId: Int): ShoppingCart? {
        return dao.getByUserId(userId);
    }

    suspend fun create(shoppingCart: ShoppingCart) {
        dao.insert(shoppingCart)
    }

    suspend fun update(shoppingCart: ShoppingCart) {
        dao.update(shoppingCart)
    }

    suspend fun delete(shoppingCart: ShoppingCart) {
        dao.delete(shoppingCart)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}