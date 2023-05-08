package com.p_f.endpoints

import com.p_f.dto.ApiSuccessResponse
import io.kvision.annotations.KVService

@KVService
interface IAuthCheckerEndpointService {
    suspend fun checkAuth(): Result<ApiSuccessResponse>
}