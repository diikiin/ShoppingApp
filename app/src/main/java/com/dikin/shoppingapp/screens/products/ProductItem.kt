package com.dikin.shoppingapp.screens.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.DevParams
import com.dikin.shoppingapp.R
import com.dikin.shoppingapp.models.ProductWithCategory
import com.dikin.shoppingapp.viewmodels.CartItemViewModel

@Composable
fun ProductItem(
    product: ProductWithCategory,
    onUpdate: (ProductWithCategory) -> Unit,
    onDelete: (ProductWithCategory) -> Unit,
    cartItemViewModel: CartItemViewModel = viewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { showDialog = true }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                if (product.imageUrl == null) {
                    Icon(painterResource(R.drawable.products), contentDescription = "Default image")
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }

            Box {
                if (DevParams.debug) {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Settings")
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                onUpdate(product)
                            },
                            text = { Text("Update") }
                        )
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                onDelete(product)
                            },
                            text = { Text("Delete") }
                        )
                    }
                } else {
                    IconButton(onClick = {

                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            }
        }
    }

    if (showDialog) {
        ProductDetailDialog(product = product, onDismiss = { showDialog = false })
    }
}
