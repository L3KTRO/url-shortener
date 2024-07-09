package top.lestro.logic.http

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.serialization() {
    // Serialization
    install(ContentNegotiation) {
        json()
    }
}