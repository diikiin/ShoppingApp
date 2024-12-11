package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.Order
import com.dikin.shoppingapp.repositories.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel(application: Application): AndroidViewModel(application) {

    private val repository: OrderRepository
    val all: LiveData<List<Order>>

    init {
        val dao = AppDatabase.getDatabase(application).orderDao()
        repository = OrderRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Int, callback: (Order?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(order: Order) = viewModelScope.launch {
        repository.create(order)
    }

    fun update(order: Order) = viewModelScope.launch {
        repository.update(order)
    }

    fun delete(order: Order) = viewModelScope.launch {
        repository.delete(order)
    }

    fun deleteById(id: Int) = viewModelScope.launch {
        repository.deleteById(id)
    }
}