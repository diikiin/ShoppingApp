package com.dikin.shoppingapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dikin.shoppingapp.entities.User

@Composable
fun UserProfileScreen() {
//    val user = userViewModel.currentUser!!
    val user = User(0, "username", "email", "passwordHash")

    Spacer(Modifier.height(12.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Username: ${user.username}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfileScreen()
}