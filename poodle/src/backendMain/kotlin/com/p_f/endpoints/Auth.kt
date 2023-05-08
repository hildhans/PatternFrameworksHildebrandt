package com.p_f.endpoints

import arrow.core.continuations.either
import com.p_f.data.facades.UserFacade
import com.p_f.domain.DomainError
import com.p_f.dto.*
import com.p_f.error.ApiError
import com.p_f.util.BCryptUtils
import com.p_f.util.JwtService
import io.ktor.server.application.*
import io.kvision.remote.ServiceException

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class AuthEndpointService(
    private val userFacade: UserFacade,
    private val jwtService: JwtService,
) : IAuthEndpointService {
    override suspend fun login(data: AuthLoginRequestDto): Result<AuthLoginResponseDto> {
        return either {
            val user = userFacade
                .findByEmail(data.email)
                .mapLeft {
                    when (it) {
                        is DomainError.EntityNotFoundError -> ApiError.UnauthenticatedError("Invalid Credentials!")
                        else -> it.toApiError()
                    }
                }
                .bind()

            if (!BCryptUtils.verify(data.password, user.passwordHash)) {
                return@either shift(ApiError.UnauthenticatedError("Invalid Credentials!"))
            }

            // Generate Auth Token
            val accessToken = jwtService.generateToken(user.uid)

            AuthLoginResponseDto(
                accessToken = accessToken,
                user = AuthLoggedInUserDto(
                    fullName = user.fullName
                )
            )
        }.fold({
           Result.failure(ServiceException(it.message))
        }, {
            Result.success(it)
        })
    }

    override suspend fun signup(data: AuthRegisterRequestDto): Result<ApiSuccessResponse> {
        return either {
            val existingUser = userFacade
                .findByEmailOrNull(data.email)
                .mapLeft { it.toApiError() }
                .bind()

            existingUser?.let {
                return@either shift(ApiError.ConflictRecordError("A user with the specified email: ${data.email} already exists!"))
            }

            userFacade
                .create(
                    CreateUserDto(
                        fullName = data.fullName,
                        email = data.email,
                        passwordHash = BCryptUtils.hash(data.password)
                    )
                )
                .mapLeft { it.toApiError() }
                .bind()

            ApiSuccessResponse("Account created successfully!")
        }.fold({
            Result.failure(ServiceException(it.message))
        }, {
            Result.success(it)
        })
    }
}