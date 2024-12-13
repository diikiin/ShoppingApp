package com.dikin.shoppingapp.screens.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.dikin.shoppingapp.R
import com.dikin.shoppingapp.models.ProductWithCategory

@Composable
fun ProductAddToCart(
    product: ProductWithCategory,
    onAddToCart: (ProductWithCategory, Long) -> Unit,
    onDismiss: () -> Unit
) {
    var quantity by remember { mutableLongStateOf(1) }

    Dialog(
        onDismissRequest = { onDismiss() },
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Add to cart")

                Text(text = "Name: ${product.name}", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { quantity-- },
                        enabled = quantity > 1
                    ) {
                        Icon(painterResource(R.drawable.remove), contentDescription = "Remove")
                    }
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(quantity.toString())
                    }
                    IconButton(
                        onClick = { quantity++ }
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Remove")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Price: ${product.price * quantity}$", fontSize = 16.sp)

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(
                        onClick = { onAddToCart(product, quantity) }
                    ) {
                        Text("Add")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun prev() {
    var quantity = 1
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { quantity-- },
            enabled = quantity > 1
        ) {
            Icon(painterResource(R.drawable.remove), contentDescription = "Remove")
        }
        Text(quantity.toString())
        IconButton(
            onClick = { quantity++ }
        ) {
            Icon(Icons.Default.Add, contentDescription = "Remove")
        }
    }
}