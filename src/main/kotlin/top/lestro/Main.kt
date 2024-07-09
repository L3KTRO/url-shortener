package top.lestro

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import top.lestro.logic.http.http
import top.lestro.logic.http.routing
import top.lestro.logic.http.serialization
import java.lang.System.exit
import kotlin.system.exitProcess

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt(), host = System.getenv("HOST"), module = {
        http()
        routing()
        serialization()
    }).start(wait = true)
}
