package com.p_f

import io.kvision.state.ObservableValue

object Model {

    private val profileService = ProfileService()
    private val userService = UserService()
    private val registerProfileService = RegisterProfileService()

    val profile = ObservableValue(Profile())

    suspend fun deleteUser(id: Int): Boolean {
        return Security.withAuth {
            val result = userService.deleteUser(id)
            result
        }
    }

    suspend fun readProfile() {
        Security.withAuth {
            profile.value = profileService.getProfile()
        }
    }

    suspend fun registerProfile(profile: Profile, password: String): Boolean {
        return try {
            registerProfileService.registerProfile(profile, password)
        } catch (e: Exception) {
            console.log(e)
            false
        }
    }
}
