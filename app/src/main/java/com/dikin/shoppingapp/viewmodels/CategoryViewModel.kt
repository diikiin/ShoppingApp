package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.Category
import com.dikin.shoppingapp.repositories.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CategoryRepository
    val all: LiveData<List<Category>>

    init {
        val dao = AppDatabase.getDatabase(application).categoryDao()
        repository = CategoryRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Long, callback: (Category?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(category: Category) = viewModelScope.launch {
        repository.create(category)
    }

    fun update(category: Category) = viewModelScope.launch {
        repository.update(category)
    }

    fun delete(category: Category) = viewModelScope.launch {
        repository.delete(category)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}