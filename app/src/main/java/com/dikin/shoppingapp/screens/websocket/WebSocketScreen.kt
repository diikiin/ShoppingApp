package com.dikin.shoppingapp.screens.websocket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dikin.shoppingapp.screens.PageTitle
import com.dikin.shoppingapp.viewmodels.WebSocketViewModel

@Composable
fun WebSocketScreen(
    modifier: Modifier = Modifier,
    webSocketViewModel: WebSocketViewModel = viewModel()
) {
    val socketStatus by webSocketViewModel.socketStatus.observeAsState(false)
    val messages by webSocketViewModel.receivedMessages.collectAsState()
    var inputMessage by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        PageTitle("Web Socket")

        Text(
            text = if (socketStatus) "Connected" else "Disconnected",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            color = if (socketStatus) Color.Green else Color.Red
        )

        Button(
            onClick = {
                webSocketViewModel.connect()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Connect")
        }

        Button(
            onClick = {
                webSocketViewModel.close()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Disconnect")
        }

        TextField(
            value = inputMessage,
            onValueChange = { inputMessage = it },
            label = { Text("Type a message") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                webSocketViewModel.sendMessage(inputMessage)
                inputMessage = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Send Message")
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(messages.toList()) { message ->
                Text(text = message, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
