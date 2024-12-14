package com.dikin.shoppingapp.screens.shopping_cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.viewmodels.ShoppingCartViewModel
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun ShoppingCartScreen(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier,
    shoppingCartViewModel: ShoppingCartViewModel = viewModel()
) {
    val user = userViewModel.currentUser!!
    val shoppingCart = shoppingCartViewModel.getByUserIdWithItems(user.userId)

    val cartItems by shoppingCart.items.observeAsState(emptyList())

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Shopping Cart",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Your Cart is Empty!",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center
                )
            }
        } else {
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
    }
}
