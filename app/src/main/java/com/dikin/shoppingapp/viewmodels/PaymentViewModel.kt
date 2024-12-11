package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.Payment
import com.dikin.shoppingapp.repositories.PaymentRepository
import kotlinx.coroutines.launch

class PaymentViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PaymentRepository
    val all: LiveData<List<Payment>>

    init {
        val dao = AppDatabase.getDatabase(application).paymentDao()
        repository = PaymentRepository(dao)
        all = repository.all.asLiveData()
    }

    fun getById(id: Int, callback: (Payment?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun create(payment: Payment) = viewModelScope.launch {
        repository.create(payment)
    }

    fun update(payment: Payment) = viewModelScope.launch {
        repository.update(payment)
    }

    fun delete(payment: Payment) = viewModelScope.launch {
        repository.delete(payment)
    }

    fun deleteById(id: Int) = viewModelScope.launch {
        repository.deleteById(id)
    }
}