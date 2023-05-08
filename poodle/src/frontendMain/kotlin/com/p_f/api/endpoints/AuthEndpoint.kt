package com.p_f.api.endpoints

import arrow.core.Either
import com.p_f.api.apiUrl
import com.p_f.api.httpClient
import com.p_f.dto.*
import com.p_f.endpoints.IAuthEndpointService
import com.p_f.error.ApiError
import com.p_f.util.LocalStorageFacade
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/*
object AuthEndpointServiceImpl : IAuthEndpointService {
    private const val baseUrl = "$apiUrl/auth"

    override suspend fun login(data: AuthLoginRequestDto): Either<ApiError, AuthLoginResponseDto> {
        return Either.catch {
            val response: HttpResponse = httpClient.post {
                url("$baseUrl/login")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
                setBody(data)
            }

            if (response.status.isSuccess()) {
                val responseBody = response.body<AuthLoginResponseDto>()
                return Either.Right(responseBody)
            } else {
                val errorBody = response.body<ApiErrorResponse>()
                return Either.Left(ApiError.GenericError(errorBody.message))
            }
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }

    override suspend fun signup(data: AuthRegisterRequestDto): Either<ApiError, ApiSuccessResponse> {
        return Either.catch {
            val response: HttpResponse = httpClient.post {
                url("$baseUrl/register")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
                setBody(data)
            }

            if (response.status.isSuccess()) {
                val responseBody = response.body<ApiSuccessResponse>()
                return Either.Right(responseBody)
            }
            else {
                val errorBody = response.body<ApiErrorResponse>()
                return Either.Left(ApiError.GenericError(errorBody.message))
            }
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }

    override suspend fun checkAuth(): Either<ApiError, ApiSuccessResponse> {
        return Either.catch {
            val response: HttpResponse = httpClient.get {
                url("$baseUrl/check-auth")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
                bearerAuth(LocalStorageFacade.getAccessToken() ?: "")
            }

            when {
                response.status.isSuccess() -> {
                    val responseBody = response.body<ApiSuccessResponse>()
                    return Either.Right(responseBody)
                }
                else -> {
                    val errorBody = response.body<ApiErrorResponse>()
                    return Either.Left(ApiError.GenericError(errorBody.message))
                }
            }
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }
}*/
