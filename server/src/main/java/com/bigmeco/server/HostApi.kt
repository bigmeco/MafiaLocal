package com.bigmeco.server

import io.ktor.http.cio.websocket.CloseReason
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.close
import io.ktor.http.cio.websocket.readText
import io.ktor.routing.routing
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.websocket.WebSockets
import io.ktor.websocket.webSocket
import kotlinx.coroutines.channels.mapNotNull
import io.ktor.application.*
import io.ktor.html.respondHtml
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.server.netty.Netty
import kotlinx.html.*


object HostApi {
    private fun Application.module() {
        install(WebSockets)
            routing {
                webSocket("/ws") { // websocketSession
                    for (frame in incoming.mapNotNull { it as? Frame.Text }) {
                        val text = frame.readText()
                        send(Frame.Text("YOU SAID $text"))
                        if (text.equals("bye", ignoreCase = true)) {
                            close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
                        }

                    }
                }
                get("/") {
                    call.respondHtml {
                        head {
                            title { +"Async World" }
                        }
                        body {
                            h1( "ты пидор") {
                                +"ЖИ ЕСТЬ ПИДР"
                            }
                            img { src= "https://sun9-73.userapi.com/c857136/v857136202/1670e7/hsf3ggwypys.jpg" }
                        }
                    }
                }
        }
    }

    fun start() {
        val server = embeddedServer(CIO, port = 8080) {
            module()
        }
        server.start()
    }
    // тест rest


}