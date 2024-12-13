package com.dikin.shoppingapp.screens.shopping_cart

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dikin.shoppingapp.models.CartItemWithProduct

@Composable
fun CartItem(cartItem: CartItemWithProduct) {
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
                text = "Quantity: ${cartItem.quantity}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Price: $${cartItem.quantity * cartItem.productPrice}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}