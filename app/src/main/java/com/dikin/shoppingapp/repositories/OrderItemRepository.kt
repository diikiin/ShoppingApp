package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.OrderItemDao
import com.dikin.shoppingapp.entities.OrderItem
import kotlinx.coroutines.flow.Flow

class OrderItemRepository(private val dao: OrderItemDao) {
    val all: Flow<List<OrderItem>> = dao.getAll()

    suspend fun getById(id: Int): OrderItem? {
        return dao.getById(id)
    }

    suspend fun create(orderItem: OrderItem) {
        dao.insert(orderItem)
    }

    suspend fun update(orderItem: OrderItem) {
        dao.update(orderItem)
    }

    suspend fun delete(orderItem: OrderItem) {
        dao.delete(orderItem)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}