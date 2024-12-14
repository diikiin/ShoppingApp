package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.Payment
import com.dikin.shoppingapp.repositories.PaymentRepository
import kotlinx.coroutines.launch

class PaymentViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PaymentRepository

    init {
        val dao = AppDatabase.getDatabase(application).paymentDao()
        repository = PaymentRepository(dao)
    }

    fun getById(id: Long, callback: (Payment?) -> Unit) = viewModelScope.launch {
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

    fun deleteById(id: Long) = viewModelScope.launch {
        repository.deleteById(id)
    }
}