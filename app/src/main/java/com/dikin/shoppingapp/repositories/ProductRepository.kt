package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.ProductDao
import com.dikin.shoppingapp.entities.Product
import com.dikin.shoppingapp.models.ProductWithCategory
import kotlinx.coroutines.flow.Flow

class ProductRepository(private val dao: ProductDao) {
    val all: Flow<List<ProductWithCategory>> = dao.getAll()

    fun getById(id: Long): ProductWithCategory? {
        return dao.getById(id)
    }

    suspend fun create(product: Product) {
        dao.insert(product)
    }

    suspend fun update(product: Product) {
        dao.update(product)
    }

    suspend fun delete(product: Product) {
        dao.delete(product)
    }

    suspend fun deleteById(id: Long) {
        dao.deleteById(id)
    }
}