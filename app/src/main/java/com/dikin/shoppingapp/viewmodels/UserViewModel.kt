package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.User
import com.dikin.shoppingapp.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val all: LiveData<List<User>>

    init {
        val dao = AppDatabase.getDatabase(application).userDao()
        repository = UserRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Int, callback: (User?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(user: User) = viewModelScope.launch {
        repository.create(user)
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
    }

    fun deleteById(id: Int) = viewModelScope.launch {
        repository.deleteById(id)
    }
}