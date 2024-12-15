package com.dikin.shoppingapp.screens.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dikin.shoppingapp.models.ProductWithCategory

@Composable
fun ProductDetailDialog(
    product: ProductWithCategory,
    onDismiss: () -> Unit,
    onNavigateToComments: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Task Details") },
        text = {
            Column {
                Text(text = "Name: ${product.name}", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Description: ${product.description}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Price: $${product.price}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Category: ${product.categoryName}", fontSize = 16.sp)
            }
        },
        confirmButton = {
            Row {
                TextButton(onClick = { onNavigateToComments() }) {
                    Text("View Comments")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = onDismiss) {
                    Text("Close")
                }
            }
        }
    )
}
