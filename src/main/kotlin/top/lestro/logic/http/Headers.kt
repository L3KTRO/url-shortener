package top.lestro.logic.http

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.defaultheaders.*

fun Application.http() {
    install(CORS) {
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Delete)
        anyHost()
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
        header("Access-Control-Allow-Origin", "*")
        header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
    }
}