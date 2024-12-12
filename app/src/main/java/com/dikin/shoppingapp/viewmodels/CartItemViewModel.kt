package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.CartItem
import com.dikin.shoppingapp.models.CartItemWithProduct
import com.dikin.shoppingapp.repositories.CartItemRepository
import kotlinx.coroutines.launch

class CartItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CartItemRepository
    val all: LiveData<List<CartItem>>

    init {
        val dao = AppDatabase.getDatabase(application).cartItemDao()
        repository = CartItemRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Long, callback: (CartItem?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun getByCartId(cartId: Long): LiveData<List<CartItemWithProduct>> {
        return repository.getByCartId(cartId).asLiveData()
    }

    fun create(cartItem: CartItem) = viewModelScope.launch {
        repository.create(cartItem)
    }

    fun update(cartItem: CartItem) = viewModelScope.launch {
        repository.update(cartItem)
    }

    fun delete(cartItem: CartItem) = viewModelScope.launch {
        repository.delete(cartItem)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}