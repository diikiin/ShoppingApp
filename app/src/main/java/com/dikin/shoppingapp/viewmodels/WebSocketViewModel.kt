package com.dikin.shoppingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dikin.shoppingapp.config.WebSocketManager
import com.dikin.shoppingapp.websocket.CustomWebSocketListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WebSocketViewModel : ViewModel() {

    private val webSocketManager = WebSocketManager()

    private val _receivedMessages = MutableStateFlow<List<String>>(emptyList())
    val receivedMessages: StateFlow<List<String>> = _receivedMessages
    private val _socketStatus = MutableLiveData(false)
    val socketStatus: LiveData<Boolean> = _socketStatus

    private val webSocketListener = CustomWebSocketListener { message ->
        _receivedMessages.value += message
    }

    fun connect() {
        webSocketManager.connect(webSocketListener)
        _socketStatus.value = true
    }

    fun sendMessage(message: String) {
        webSocketManager.sendMessage(message)
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.close()
    }

    fun close() {
        webSocketManager.close()
        _socketStatus.value = false
    }
}