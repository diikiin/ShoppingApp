package com.dikin.shoppingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dikin.shoppingapp.config.AppDatabase
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.models.CartItemWithProduct
import com.dikin.shoppingapp.models.CartWithItems
import com.dikin.shoppingapp.repositories.ShoppingCartRepository
import kotlinx.coroutines.launch

class ShoppingCartViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ShoppingCartRepository
    private val cartItemViewModel = CartItemViewModel(application)

    init {
        val dao = AppDatabase.getDatabase(application).shoppingCartDao()
        repository = ShoppingCartRepository(dao)
    }

    fun getById(id: Long, callback: (ShoppingCart?) -> Unit) = viewModelScope.launch {
        callback(repository.getById(id))
    }

    fun getByUserId(userId: Long, callback: (ShoppingCart?) -> Unit) = viewModelScope.launch {
        callback(repository.getByUserId(userId))
    }

    fun getByUserIdWithItems(userId: Long): CartWithItems {
        val cart = repository.getByUserIdCurrentThread(userId)
        var cartItems = MutableLiveData<List<CartItemWithProduct>>(emptyList())
        cart?.let {
            cartItems =
                cartItemViewModel.getByCartId(cart.cartId) as MutableLiveData<List<CartItemWithProduct>>
        }
        val cartWithItems = CartWithItems(cart!!.cartId, cart.userId, cartItems)
        return cartWithItems
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

    fun clearCart(id: Long) = viewModelScope.launch {
        cartItemViewModel.clearCart(id)
    }
}