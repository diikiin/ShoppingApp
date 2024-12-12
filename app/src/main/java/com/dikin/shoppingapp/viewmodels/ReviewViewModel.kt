package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.Review
import com.dikin.shoppingapp.repositories.ReviewRepository
import kotlinx.coroutines.launch

class ReviewViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ReviewRepository
    val all: LiveData<List<Review>>

    init {
        val dao = AppDatabase.getDatabase(application).reviewDao()
        repository = ReviewRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Long, callback: (Review?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(review: Review) = viewModelScope.launch {
        repository.create(review)
    }

    fun update(review: Review) = viewModelScope.launch {
        repository.update(review)
    }

    fun delete(review: Review) = viewModelScope.launch {
        repository.delete(review)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}