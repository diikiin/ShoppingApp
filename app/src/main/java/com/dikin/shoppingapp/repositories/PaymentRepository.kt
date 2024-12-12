package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.PaymentDao
import com.dikin.shoppingapp.entities.Payment
import kotlinx.coroutines.flow.Flow

class PaymentRepository(private val dao: PaymentDao) {
    val all: Flow<List<Payment>> = dao.getAll()

    suspend fun getById(id: Long): Payment? {
        return dao.getById(id)
    }

    suspend fun create(payment: Payment) {
        dao.insert(payment)
    }

    suspend fun update(payment: Payment) {
        dao.update(payment)
    }

    suspend fun delete(payment: Payment) {
        dao.delete(payment)
    }

    suspend fun deleteById(id: Long) {
        dao.deleteById(id)
    }
}