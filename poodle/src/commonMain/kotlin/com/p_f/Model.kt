@file:UseContextualSerialization(LocalDateTime::class)

package com.p_f

import io.kvision.types.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization

@Serializable
data class UserAddressCom(val address: Address)

@Serializable
data class UserCom(val user: User)

@Serializable
data class User(
    val id: Int? = 0,
    val name: String? = null,
    val username: String? = null,
    val password: String? = null,
    val password2: String? = null,
    val roleid:Int? = null
)

@Serializable
data class Address(
    val id: Int? = 0,
    val firstName: String? = null,
    val lastName: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val postalAddress: String? = null,
    val bio: String? = null,
    val userimage: String? = null,
    val createdAt: LocalDateTime? = null,
    val userId: Int? = null,
    val parId: Int? = null
)

@Serializable
data class Test(
    val id: Int? = 0,
    val testName: String? = null
)

@Serializable
data class UserTest(
    val id: Int? = 0,
    val userId: Int? = null,
    val testId: Int? = null
)

@Serializable
data class AddressBookState(
    val addresses: List<Address>,
    val search: String? = null,
    val sort: Sort = Sort.FN,
    val editMode: EditMode? = null,
    val editIndex: Int? = null,
    val editAddress: Address? = null
)