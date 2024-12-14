package com.dikin.shoppingapp.screens.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.DevParams
import com.dikin.shoppingapp.entities.Category
import com.dikin.shoppingapp.models.ProductWithCategory
import com.dikin.shoppingapp.viewmodels.CategoryViewModel
import com.dikin.shoppingapp.viewmodels.ProductViewModel
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun ProductsCatalogScreen(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier,
    productViewModel: ProductViewModel = viewModel(),
    categoryViewModel: CategoryViewModel = viewModel()
) {
    val products by productViewModel.all.observeAsState(emptyList())
    var showedProducts = products
    val categories by categoryViewModel.all.observeAsState(emptyList())
    var selectedProduct by remember { mutableStateOf<ProductWithCategory?>(null) }
    var selectedCategory by remember { mutableStateOf<Category?>(null) }

    var showDialog by remember { mutableStateOf(false) }
    var showAddCategoryDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Products Catalog",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        if (DevParams.debug) {
            Button(
                onClick = {
                    showDialog = true
                    selectedProduct = null
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Add Product")
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    showAddCategoryDialog = true
                    selectedProduct = null
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Add Category")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            CategoryDropdown(
                categories = categories,
                selectedCategory = selectedCategory,
                showUnselect = true,
                onCategorySelected = { category ->
                    selectedCategory = category
                }
            )
        }

        if (selectedCategory != null) {
            showedProducts = products.filter { p -> p.categoryId == selectedCategory?.categoryId }
        }

        LazyColumn {
            items(showedProducts) { product ->
                ProductItem(
                    userViewModel = userViewModel,
                    product = product,
                    onUpdate = {
                        selectedProduct = it
                        showDialog = true
                    },
                    onDelete = {
                        productViewModel.deleteById(it.productId)
                    }
                )
            }
        }
    }

    if (showDialog) {
        AddOrUpdateProductDialog(
            product = selectedProduct,
            categories = categories,
            onCreate = { product ->
                productViewModel.create(product)
                showDialog = false
            },
            onUpdate = { product ->
                productViewModel.update(product)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }

    if (showAddCategoryDialog) {
        AddCategoryDialog(
            onCreate = { category ->
                categoryViewModel.create(category)
                showAddCategoryDialog = false
            },
            onDismiss = { showAddCategoryDialog = false }
        )
    }
}
