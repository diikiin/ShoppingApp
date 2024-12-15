package com.dikin.shoppingapp.websocket

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class CustomWebSocketListener(
    private val onMessageReceived: (String) -> Unit
) : WebSocketListener() {

    private val WEBSOCKET_TAG = "WebSocket"

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        Log.i(WEBSOCKET_TAG, "WebSocket opened: $response")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        onMessageReceived(text)
        Log.i(WEBSOCKET_TAG, "Message Received: $text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
        Log.i(WEBSOCKET_TAG, "Binary Message Received: $bytes")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        Log.i(WEBSOCKET_TAG, "WebSocket Closing: $code / $reason")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        Log.i(WEBSOCKET_TAG, "WebSocket Failure: ${t.message}")
    }
}