package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.CartItemDao
import com.dikin.shoppingapp.entities.CartItem
import com.dikin.shoppingapp.models.CartItemWithProduct
import kotlinx.coroutines.flow.Flow

class CartItemRepository(private val dao: CartItemDao) {
    val all: Flow<List<CartItem>> = dao.getAll()

    suspend fun getById(id: Int): CartItem? {
        return dao.getById(id)
    }

    suspend fun getByCartId(cartId: Int): Flow<List<CartItemWithProduct>> {
        return dao.getByCartId(cartId)
    }

    suspend fun create(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    suspend fun update(cartItem: CartItem) {
        dao.update(cartItem)
    }

    suspend fun delete(cartItem: CartItem) {
        dao.delete(cartItem)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}