package com.dikin.shoppingapp.screens.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.dikin.shoppingapp.entities.Category
import com.dikin.shoppingapp.entities.Product
import com.dikin.shoppingapp.models.ProductWithCategory

@Composable
fun AddOrUpdateProductDialog(
    product: ProductWithCategory?,
    categories: List<Category>,
    onCreate: (Product) -> Unit,
    onUpdate: (Product) -> Unit,
    onDismiss: () -> Unit
) {
    var name by remember { mutableStateOf(product?.name ?: "") }
    var description by remember { mutableStateOf(product?.description ?: "") }
    var price by remember { mutableDoubleStateOf(product?.price ?: 0.0) }
    var category: Category? by remember { mutableStateOf(null) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Add/Update Product", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Product Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Product Description") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = price.toString(),
                    onValueChange = { price = it.trim().toDouble() },
                    label = { Text("Product Price") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                CategoryDropdown(
                    categories = categories,
                    selectedCategory = category,
                    onCategorySelected = { categorySelect ->
                        category = categorySelect
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    TextButton(
                        onClick = {
                            if (name.isNotBlank() && price > 0.0) {
                                if (product != null) {
                                    onUpdate(
                                        Product(
                                            product.productId,
                                            name,
                                            description,
                                            product.price,
                                            null,
                                            product.categoryId
                                        )
                                    )
                                } else {
                                    onCreate(
                                        Product(
                                            name = name,
                                            description = description,
                                            price = price,
                                            imageUrl = null,
                                            categoryId = category?.categoryId
                                        )
                                    )
                                }
                            }
                        }
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}
