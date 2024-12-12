package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.UserAddress
import com.dikin.shoppingapp.repositories.UserAddressRepository
import kotlinx.coroutines.launch

class UserAddressViewModel(application: Application): AndroidViewModel(application) {

    private val repository: UserAddressRepository
    val all: LiveData<List<UserAddress>>

    init {
        val dao = AppDatabase.getDatabase(application).userAddressDao()
        repository = UserAddressRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Long, callback: (UserAddress?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(userAddress: UserAddress) = viewModelScope.launch {
        repository.create(userAddress)
    }

    fun update(userAddress: UserAddress) = viewModelScope.launch {
        repository.update(userAddress)
    }

    fun delete(userAddress: UserAddress) = viewModelScope.launch {
        repository.delete(userAddress)
    }

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}