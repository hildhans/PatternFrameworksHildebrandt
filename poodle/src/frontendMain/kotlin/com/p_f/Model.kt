package com.p_f

import io.kvision.state.ObservableList
import io.kvision.state.ObservableValue
import io.kvision.state.observableListOf
import io.kvision.utils.syncWithList
import kotlinx.coroutines.launch


object Model {

    private val userService = UserService()
    private val userAddressService = UserAddressService()
    private val registerUserService = RegisterUserService()

    val userAddress: ObservableList<Address> = observableListOf()
    val user = ObservableValue(User())

    var search: String? = null
        set(value) {
            field = value
            AppScope.launch {
                getUserAddressList()
            }
        }
    var types: String = "all"
        set(value) {
            field = value
            AppScope.launch {
                getUserAddressList()
            }
        }
    var sort = Sort.FN
        set(value) {
            field = value
            AppScope.launch {
                getUserAddressList()
            }
        }

    suspend fun getUserAddressList() {
        Security.withAuth {
            val newUserAddresses = userAddressService.getUserAddressList(search, types, sort)
            userAddress.syncWithList(newUserAddresses)
        }
    }

    suspend fun addUserAddress(address: Address) {
        Security.withAuth {
            userAddressService.addUserAddress(address)
            getUserAddressList()
        }
    }

    suspend fun updateUserAddress(address: Address) {
        Security.withAuth {
            userAddressService.updateUserAddress(address)
            getUserAddressList()
        }
    }

    suspend fun deleteUserAddress(id: Int): Boolean {
        return Security.withAuth {
            val result = userAddressService.deleteUserAddress(id)
            getUserAddressList()
            result
        }
    }

    suspend fun readUser() {
        Security.withAuth {
            user.value = userService.getUser()
        }
    }

    suspend fun registerUser(user: User, password: String): Boolean {
        return try {
            registerUserService.registerUser(user, password)
        } catch (e: Exception) {
            console.log(e)
            false
        }
    }
}
