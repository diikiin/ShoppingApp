package com.dikin.shoppingapp.repositories

import com.dikin.shoppingapp.daos.ReviewDao
import com.dikin.shoppingapp.entities.Review
import kotlinx.coroutines.flow.Flow

class ReviewRepository(private val dao: ReviewDao) {
    val all: Flow<List<Review>> = dao.getAll()

    suspend fun getById(id: Long): Review? {
        return dao.getById(id)
    }

    suspend fun create(review: Review) {
        dao.insert(review)
    }

    suspend fun update(review: Review) {
        dao.update(review)
    }

    suspend fun delete(review: Review) {
        dao.delete(review)
    }

    suspend fun deleteById(id: Long) {
        dao.deleteById(id)
    }
}