package com.p_f.routes.contact

import arrow.core.continuations.either
import com.p_f.dto.CreateContactDto
import com.p_f.dto.UpdateContactDto
import com.p_f.endpoints.IContactEndpointService
import com.p_f.error.ApiError
import com.p_f.routes.handleError
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

/*
fun Route.contactRoutes() {

    val contactEndpointService by inject<IContactEndpointService>()

    route("/contacts") {

        get("/list") {
            either {
                val apiResponse = contactEndpointService.list().bind()
                call.respond(
                    status = HttpStatusCode.OK,
                    apiResponse
                )
            }.mapLeft {
                handleError(it)
            }
        }

        get("/find/uid/{uid}") {
            either {
                val contactUid = call.parameters["uid"] ?: return@either shift(ApiError.BadRequestError("The request payload is invalid!"))

                val apiResponse = contactEndpointService.findByUid(contactUid).bind()
                call.respond(
                    status = HttpStatusCode.OK,
                    apiResponse
                )
            }.mapLeft {
                handleError(it)
            }
        }

        post("/create") {
            either {
                val requestBody = runCatching {
                    call.receive<CreateContactDto>()
                }.getOrNull() ?: return@either shift(ApiError.BadRequestError("The request payload is invalid!"))

                val apiResponse = contactEndpointService.create(requestBody).bind()
                call.respond(
                    status = HttpStatusCode.Created,
                    apiResponse
                )
            }.mapLeft {
                handleError(it)
            }
        }

        patch("/update/{uid}") {
            either {
                val contactUid = call.parameters["uid"] ?: return@either shift(ApiError.BadRequestError("The request payload is invalid!"))

                val requestBody = runCatching {
                    call.receive<UpdateContactDto>()
                }.getOrNull() ?: return@either shift(ApiError.BadRequestError("The request payload is invalid!"))

                val apiResponse = contactEndpointService.update(contactUid, requestBody).bind()
                call.respond(
                    status = HttpStatusCode.OK,
                    apiResponse
                )
            }.mapLeft {
                handleError(it)
            }
        }

        delete("/delete/{uid}") {
            either {
                val contactUid = call.parameters["uid"] ?: return@either shift(ApiError.BadRequestError("The request payload is invalid!"))

                val apiResponse = contactEndpointService.delete(contactUid).bind()
                call.respond(
                    status = HttpStatusCode.NoContent,
                    apiResponse
                )
            }.mapLeft {
                handleError(it)
            }
        }
    }
}*/
