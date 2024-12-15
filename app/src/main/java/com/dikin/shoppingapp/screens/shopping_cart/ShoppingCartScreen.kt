package com.dikin.shoppingapp.screens.shopping_cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.screens.PageTitle
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
        PageTitle("Shopping Cart")

        if (cartItems.isEmpty()) {
            EmptyCart()
        } else {
            CartBody(cartItems, shoppingCart, shoppingCartViewModel)
        }
    }
}
