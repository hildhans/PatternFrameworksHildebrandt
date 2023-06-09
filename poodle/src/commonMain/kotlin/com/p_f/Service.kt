package com.p_f

import io.kvision.annotations.KVService
import kotlinx.serialization.Serializable

@Serializable
enum class Sort {
    FN, LN, E, F
}

@KVService
interface IUserAddressService {
    suspend fun getUserAddressList(search: String?, types: String, sort: Sort): List<Address>
    suspend fun addUserAddress(address: Address): Address
    suspend fun updateUserAddress(address: Address): Address
    suspend fun deleteUserAddress(id: Int): Boolean
    //suspend fun getUserAddress(id: Int): Address
}

@KVService
interface IUserService {
    suspend fun getUser(): User
}

@KVService
interface IRegisterUserService {
    suspend fun registerUser(user: User, password: String): Boolean
}
