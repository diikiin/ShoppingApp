package com.dikin.shoppingapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun UserProfileScreen(
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {
    val user = userViewModel.currentUser!!

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Username: ${user.username}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.titleLarge)
        }
    }
}
