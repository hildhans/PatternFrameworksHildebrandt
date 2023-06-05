package com.p_f

import io.kvision.annotations.KVService

@KVService
interface IUserService {

    //suspend fun updateUser(user: User): Address
    suspend fun getUser(): Profile
    suspend fun deleteUser(id: Int): Boolean
}

@KVService
interface IProfileService {
    suspend fun getProfile(): Profile
}

@KVService
interface IRegisterProfileService {
    suspend fun registerProfile(profile: Profile, password: String): Boolean
}
