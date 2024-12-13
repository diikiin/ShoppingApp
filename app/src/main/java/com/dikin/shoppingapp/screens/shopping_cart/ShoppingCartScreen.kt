package com.dikin.shoppingapp.screens.shopping_cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.models.CartItemWithProduct
import com.dikin.shoppingapp.viewmodels.CartItemViewModel
import com.dikin.shoppingapp.viewmodels.ShoppingCartViewModel
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun ShoppingCartScreen(
    userViewModel: UserViewModel,
    shoppingCartViewModel: ShoppingCartViewModel = viewModel(),
    cartItemViewModel: CartItemViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val user = userViewModel.currentUser!!
    var shoppingCart: ShoppingCart? = null
    shoppingCartViewModel.getByUserId(user.userId) { result ->
        shoppingCart = result
    }

    var cartItems: List<CartItemWithProduct>? = emptyList()
    if (shoppingCart != null) {
        cartItems = cartItemViewModel.getByCartId(shoppingCart!!.cartId).value
    }

    Column(modifier = modifier.fillMaxSize()) {
        if (cartItems.isNullOrEmpty()) {
            Text("Your Cart is Empty!")
        }
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems ?: emptyList()) { cartItem ->
                CartItem(cartItem)
            }
        }
    }
}
