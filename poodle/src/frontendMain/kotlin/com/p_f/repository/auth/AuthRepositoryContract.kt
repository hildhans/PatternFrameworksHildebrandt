package com.p_f.repository.auth

import com.p_f.dto.AuthLoggedInUserDto

object AuthRepositoryContract {
    data class State(
        val initialized: Boolean = false,
        val isLoggedIn: Boolean = true,
        val accessToken: String? = null,
        val userData: AuthLoggedInUserDto? = null
    )

    sealed class Inputs {
        object Initialize : Inputs()
        data class LogIn(val accessToken: String, val userData: AuthLoggedInUserDto) : Inputs()
        object LogOut : Inputs()
        object CheckAuth : Inputs()
    }
}
