@file:UseContextualSerialization(LocalDateTime::class)

package com.p_f

import io.kvision.types.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization

@Serializable
data class Profile(
    val id: Int? = null,
    val name: String? = null,
    val username: String? = null,
    val password: String? = null,
    val password2: String? = null
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