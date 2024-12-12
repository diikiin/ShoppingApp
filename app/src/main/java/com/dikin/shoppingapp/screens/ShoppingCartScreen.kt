package com.dikin.shoppingapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    if (shoppingCart == null) {
        shoppingCartViewModel.create(ShoppingCart(userId = user.userId))
        shoppingCartViewModel.getByUserId(user.userId) { result ->
            shoppingCart = result
        }
    }

    var cartItems: List<CartItemWithProduct>? = emptyList()
    if (shoppingCart != null) {
        cartItems = cartItemViewModel.getByCartId(shoppingCart!!.cartId).value
    }

    Column(modifier = Modifier.fillMaxSize()) {
        if (cartItems.isNullOrEmpty()) {
            Text("Your Cart is Empty!")
        }
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems ?: emptyList()) { cartItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = cartItem.productName,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Qty: ${cartItem.quantity}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "$${cartItem.quantity * cartItem.productPrice}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
