package com.dikin.shoppingapp.screens.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dikin.shoppingapp.screens.PageTitle
import com.dikin.shoppingapp.viewmodels.UserViewModel

@Composable
fun UserProfileScreen(
    userViewModel: UserViewModel,
    onNavigateToWebSocket: () -> Unit,
    modifier: Modifier = Modifier
) {
    val user = userViewModel.currentUser!!

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        PageTitle("Profile")

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Username: ${user.username}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.titleLarge)
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        TextButton(
            onClick = { onNavigateToWebSocket() },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
        ) {
            Text("Open Web Socket")
        }
        HorizontalDivider()
    }
}
