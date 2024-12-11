package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.OrderDao
import com.dikin.shoppingapp.entities.Order
import kotlinx.coroutines.flow.Flow

class OrderRepository(private val dao: OrderDao) {
    val all: Flow<List<Order>> = dao.getAll()

    suspend fun getById(id: Int): Order? {
        return dao.getById(id)
    }

    suspend fun create(order: Order) {
        dao.insert(order)
    }

    suspend fun update(order: Order) {
        dao.update(order)
    }

    suspend fun delete(order: Order) {
        dao.delete(order)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}