package com.dikin.shoppingapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.dikin.shoppingapp.entities.Product
import com.dikin.shoppingapp.viewmodels.ProductViewModel

@Composable
fun ProductsCatalogScreen(
    productViewModel: ProductViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val products by productViewModel.all.observeAsState(emptyList())
    var selected by remember { mutableStateOf<Product?>(null) }
    var showDialog by remember { mutableStateOf(false) }

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

        Button(
            onClick = {
                showDialog = true
                selected = null
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Add Task")
        }
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onDone = {
                        taskViewModel.update(Task(task.id, task.title, task.description, true))
                    },
                    onUpdate = {
                        selected = it
                        showDialog = true
                    },
                    onDelete = {
                        taskViewModel.delete(it)
                    }
                )
            }
        }
    }

    if (showDialog) {
        AddOrUpdateTaskDialog(
            task = selected,
            onCreate = { task ->
                taskViewModel.create(task)
                showDialog = false
            },
            onUpdate = { task ->
                taskViewModel.update(task)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}