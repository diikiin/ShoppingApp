package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.repositories.ShoppingCartRepository
import kotlinx.coroutines.launch

class ShoppingCartViewModel(application: Application): AndroidViewModel(application) {

    private val repository: ShoppingCartRepository
    val all: LiveData<List<ShoppingCart>>

    init {
        val dao = AppDatabase.getDatabase(application).shoppingCartDao()
        repository = ShoppingCartRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Long, callback: (ShoppingCart?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun getByUserId(userId: Long, callback: (ShoppingCart?) -> Unit) = viewModelScope.launch {
        callback(repository.getByUserId(userId))
    }

    fun create(shoppingCart: ShoppingCart) {
        repository.create(shoppingCart)
    }

    fun update(shoppingCart: ShoppingCart) = viewModelScope.launch {
        repository.update(shoppingCart)
    }

    fun delete(shoppingCart: ShoppingCart) = viewModelScope.launch {
        repository.delete(shoppingCart)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}