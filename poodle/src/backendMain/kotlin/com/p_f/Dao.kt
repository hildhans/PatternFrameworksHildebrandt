package com.p_f

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object TestDao : Table("tests") {
    val id = integer("id").primaryKey().autoIncrement()
    val testName = varchar("Test", 255).nullable()
}

object UserTestDao : Table("ut") {
    val id = integer("id").primaryKey().autoIncrement()
    val userId = reference("user_id", UserDao.id, ReferenceOption.CASCADE, ReferenceOption.CASCADE)
    val testId = reference("test_id", UserDao.id, ReferenceOption.CASCADE, ReferenceOption.CASCADE)
}

object UserDao : Table("users") {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 255)
    val username = varchar("username", 255).uniqueIndex()
    val password = varchar("password", 255)
}
