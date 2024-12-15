package com.dikin.shoppingapp.screens.shopping_cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dikin.shoppingapp.models.CartItemWithProduct
import com.dikin.shoppingapp.models.CartWithItems
import com.dikin.shoppingapp.viewmodels.ShoppingCartViewModel

@Composable
fun CartBody(
    cartItems: List<CartItemWithProduct>,
    shoppingCart: CartWithItems,
    shoppingCartViewModel: ShoppingCartViewModel
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(cartItems) { cartItem ->
            CartItem(cartItem)
        }
    }
    Spacer(Modifier.height(16.dp))

    Text(
        text = "Total price: ${cartItems.sumOf { it.productPrice * it.quantity }}$",
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.titleMedium
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {
                shoppingCartViewModel.clearCart(shoppingCart.cartId)
            }
        ) { Text("Clear Cart") }
        Button(
            onClick = {
//                        TODO: pay logic
            }
        ) { Text("Buy") }
    }
    Spacer(Modifier.height(16.dp))
}