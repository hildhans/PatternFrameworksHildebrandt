package com.p_f

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object TestDbo : Table("tests") {
    val id = integer("id").primaryKey().autoIncrement()
    val testName = varchar("Test", 255).nullable()
}

object UserTestDbo : Table("ut") {
    val id = integer("id").primaryKey().autoIncrement()
    val userId = reference("user_id", UserDbo.id, ReferenceOption.CASCADE, ReferenceOption.CASCADE)
    val testId = reference("test_id", UserDbo.id, ReferenceOption.CASCADE, ReferenceOption.CASCADE)
}

object UserDbo : Table("user") {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 255)
    val username = varchar("username", 255).uniqueIndex()
    val password = varchar("password", 255)
}

object UserAddressDbo : Table("address") {
    val id = integer("id").primaryKey().autoIncrement()
    val firstName = varchar("first_name", 255).nullable()
    val lastName = varchar("last_name", 255).nullable()
    val email = varchar("email", 255).nullable()
    val phone = varchar("phone", 255).nullable()
    val postalAddress = varchar("postal_address", 255).nullable()
    val bio = varchar("bio", 255).nullable()
    val userimage = varchar("image", 255).nullable()
    val createdAt = datetime("created_at").nullable()
    val userId = reference("user_id", UserDbo.id, ReferenceOption.CASCADE, ReferenceOption.CASCADE)
}