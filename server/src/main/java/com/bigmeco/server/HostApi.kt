package com.bigmeco.server


import android.util.Log
import com.koushikdutta.async.AsyncServer
import com.koushikdutta.async.http.WebSocket
import com.koushikdutta.async.http.server.AsyncHttpServer


object HostApi {


    fun start() {
        val httpServer = AsyncHttpServer()
        httpServer.listen(AsyncServer.getDefault(), 8080)
        httpServer.websocket(
            "/live"
        ) { webSocket, request ->

            webSocket.setClosedCallback { ex ->
                try {
                    if (ex != null)
                        Log.e("WebSocket", "An error occurred", ex)
                } finally {
                }
            }
            webSocket.stringCallback = WebSocket.StringCallback { s ->
                if ("Hello Server" == s) {
                    webSocket.send("Welcome Client!")
                    Log.d("WebSocket", "sent")

                }
            }
        }

    }
    // тест rest


}