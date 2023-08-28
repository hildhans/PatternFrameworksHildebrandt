package com.p_f

import io.kvision.annotations.KVService
import kotlinx.serialization.Serializable

@Serializable
enum class Sort {
    FN, LN, E
}

@Serializable
enum class EditMode {
    NEW,
    EDIT
}

@KVService
interface IUserAddressService {
    suspend fun getUserAddressList(search: String?, types: String, sort: Sort): List<Address>
    suspend fun addUserAddress(address: Address): Address
    suspend fun updateUserAddress(address: Address): Address
    suspend fun deleteUserAddress(id: Int): Boolean
}

@KVService
interface IUserService {
    suspend fun getUser(): User
    suspend fun getRegUser(username: String?, password: String): Boolean
    suspend fun getAllUsers() :List<User>
    suspend fun changeUser(user: User, password: String): User
}

@KVService
interface IRegisterUserService {
    suspend fun registerUser(user: User, password: String): Boolean
}
