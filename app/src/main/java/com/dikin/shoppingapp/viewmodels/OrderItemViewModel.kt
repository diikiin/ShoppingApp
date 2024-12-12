package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.OrderItem
import com.dikin.shoppingapp.repositories.OrderItemRepository
import kotlinx.coroutines.launch

class OrderItemViewModel(application: Application): AndroidViewModel(application) {

    private val repository: OrderItemRepository
    val all: LiveData<List<OrderItem>>

    init {
        val dao = AppDatabase.getDatabase(application).orderItemDao()
        repository = OrderItemRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Long, callback: (OrderItem?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(orderItem: OrderItem) = viewModelScope.launch {
        repository.create(orderItem)
    }

    fun update(orderItem: OrderItem) = viewModelScope.launch {
        repository.update(orderItem)
    }

    fun delete(orderItem: OrderItem) = viewModelScope.launch {
        repository.delete(orderItem)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}