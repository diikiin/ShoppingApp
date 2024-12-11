package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.CategoryDao
import com.dikin.shoppingapp.entities.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val dao: CategoryDao) {
    val all: Flow<List<Category>> = dao.getAll()

    suspend fun getById(id: Int): Category? {
        return dao.getById(id)
    }

    suspend fun create(category: Category) {
        dao.insert(category)
    }

    suspend fun update(category: Category) {
        dao.update(category)
    }

    suspend fun delete(category: Category) {
        dao.delete(category)
    }

    suspend fun deleteById(id: Int) {
        dao.deleteById(id)
    }
}