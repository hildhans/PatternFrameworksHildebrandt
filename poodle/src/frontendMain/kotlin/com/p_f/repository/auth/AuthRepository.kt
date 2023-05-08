package com.p_f.repository.auth

import com.copperleaf.ballast.repository.cache.Cached
import com.p_f.dto.AuthLoggedInUserDto
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun initialize()
    fun login(accessToken: String, userData: AuthLoggedInUserDto)
    fun logOut()
    fun isLoggedIn(): Flow<Boolean>
}
