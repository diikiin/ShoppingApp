package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.Product
import com.dikin.shoppingapp.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application): AndroidViewModel(application) {

    private val repository: ProductRepository
    val all: LiveData<List<Product>>

    init {
        val dao = AppDatabase.getDatabase(application).productDao()
        repository = ProductRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Int, callback: (Product?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(product: Product) = viewModelScope.launch {
        repository.create(product)
    }

    fun update(product: Product) = viewModelScope.launch {
        repository.update(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        repository.delete(product)
    }

    fun deleteById(id: Int) = viewModelScope.launch {
        repository.deleteById(id)
    }
}