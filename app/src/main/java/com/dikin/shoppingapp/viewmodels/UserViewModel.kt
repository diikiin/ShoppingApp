package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.entities.User
import com.dikin.shoppingapp.repositories.ShoppingCartRepository
import com.dikin.shoppingapp.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    private val cartRepository: ShoppingCartRepository
    var currentUser: User? = null

    init {
        val dao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(dao)

        val cartDao = AppDatabase.getDatabase(application).shoppingCartDao()
        cartRepository = ShoppingCartRepository(cartDao)
    }

    fun getById(id: Long, callback: (User?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun getByUsername(username: String): User? {
        return repository.getByUsername(username)
    }

    fun create(user: User) {
        val userId = repository.create(user)
        cartRepository.create(ShoppingCart(userId = userId))
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}