package com.p_f.endpoints

import arrow.core.Either
import com.p_f.dto.ApiSuccessResponse
import com.p_f.dto.AuthLoginRequestDto
import com.p_f.dto.AuthLoginResponseDto
import com.p_f.dto.AuthRegisterRequestDto
import com.p_f.error.ApiError
import io.kvision.annotations.KVService

@KVService
interface IAuthEndpointService {
    suspend fun login(data: AuthLoginRequestDto): Result<AuthLoginResponseDto>
    suspend fun signup(data: AuthRegisterRequestDto): Result<ApiSuccessResponse>
}