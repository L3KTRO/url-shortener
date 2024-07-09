package top.lestro.logic.http

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import top.lestro.logic.DatabaseDriver
import top.lestro.logic.ResponseData
import top.lestro.logic.utils.toB36

fun Application.routing() {
    val service = DatabaseDriver()

    routing {

        get("/{id}") {
            val param = call.parameters["id"]
            if (param == null) {
                call.respond(HttpStatusCode.BadRequest)
            } else {
                val res = service.get(param.toB36())
                if (res == null) call.respond(HttpStatusCode.NotFound)
                else call.respondText(res.endpoint)
            }
        }

        get("/api/v1") {
            val res = service.getAll()
            call.respondText(res.toString())
        }

        post("/api/v1/") {
            val param = call.parameters["endpoint"]
            if (param == null) call.respond(HttpStatusCode.BadRequest)
            else call.respond(ResponseData(200, service.add(param)))
        }

        delete("/api/v1/{id}") {
            val param = call.parameters["id"]
            if (param == null) call.respond(HttpStatusCode.BadRequest)
            else {
                service.delete(param.toB36())
                call.respond(ResponseData(200, "OK"))
            }
        }
    }
}