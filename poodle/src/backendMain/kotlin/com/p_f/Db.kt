package com.p_f

import com.axiomalaska.jdbc.NamedParameterPreparedStatement
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.commons.codec.digest.DigestUtils
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.insert
import org.joda.time.DateTime
import java.math.BigDecimal
import java.sql.*


object Db {

    fun init(config: ApplicationConfig) {
        Database.connect(hikari(config))
        transaction {
            create(UserDbo)
            create(TestDbo)
            create(UserTestDbo)
            create(UserAddressDbo)

            //insert der ersten Datensätze
            UserRoleDbo.insert {
                it[rolename] = "Admin"
                it[description] = "Administrator"
            }
            UserRoleDbo.insert {
                it[rolename] = "Benutzer"
                it[description] = "normaler Benutzer mit vielen Rechten"
            }
            UserRoleDbo.insert {
                it[rolename] = "Kindzugang"
                it[description] = "wurde von einem Benutzer unter seinem Account eingerichtet"
            }
            UserDbo.insert {
                it[name] = "Administrator"
                it[username] = "admin"
                it[password] = DigestUtils.sha256Hex("Admin_12345")
                it[roleId] = 1
            }
            UserDbo.insert {
                it[name] = "Test"
                it[username] = "test"
                it[password] = DigestUtils.sha256Hex("Test_12345")
                it[roleId] = 2
            }
            UserDbo.insert {
                it[name] = "Keiner"
                it[username] = "keiner"
                it[password] = DigestUtils.sha256Hex("Test_12345")
                it[roleId] = 2
            }
            UserDbo.insert {
                it[name] = "Buche"
                it[username] = "buche"
                it[password] = DigestUtils.sha256Hex("Test_12345")
                it[roleId] = 2
            }
            UserAddressDbo.insert {
                it[firstName] = "Chef"
                it[lastName] = "Administrator"
                it[userName] = "admin"
                it[email] = ""
                it[phone] = ""
                it[postalAddress] = "?"
                it[bio] = "BOFH"
                it[createdAt] = DateTime().toDateTime()
                it[userId] = 1
            }
            UserAddressDbo.insert {
                it[firstName] = "Jochen"
                it[lastName] = "Test"
                it[userName] = "test"
                it[email] = "jochen.test@mail.com"
                it[phone] = "+4930123456"
                it[postalAddress] = "Berlin"
                it[bio] = "bio"
                it[createdAt] = DateTime().toDateTime()
                it[userId] = 2
            }
            UserAddressDbo.insert {
                it[firstName] = "Karin"
                it[lastName] = "Keiner"
                it[userName] = "keiner"
                it[email] = "kkeiner00@mail.de"
                it[phone] = "015299889988"
                it[postalAddress] = "Berlin"
                it[bio] = "mmmhh"
                it[createdAt] = DateTime().toDateTime()
                it[userId] = 3
            }
            UserAddressDbo.insert {
                it[firstName] = "Bertram"
                it[lastName] = "Buche"
                it[userName] = "buche"
                it[email] = "bucheb@mail.net"
                it[phone] = "040987654"
                it[postalAddress] = "Hamburg"
                it[bio] = "meer"
                it[createdAt] = DateTime().toDateTime()
                it[userId] = 4
            }
        }
    }

    private fun hikari(config: ApplicationConfig): HikariDataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.driverClassName = config.propertyOrNull("db.driver")?.getString() ?: "org.h2.Driver"
        hikariConfig.jdbcUrl = config.propertyOrNull("db.jdbcUrl")?.getString() ?: "jdbc:h2:mem:test"
        hikariConfig.username = config.propertyOrNull("db.username")?.getString()
        hikariConfig.password = config.propertyOrNull("db.password")?.getString()
        hikariConfig.maximumPoolSize = 3
        hikariConfig.isAutoCommit = false
        hikariConfig.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        hikariConfig.validate()
        return HikariDataSource(hikariConfig)
    }

    suspend fun <T> dbQuery(block: Transaction.() -> T): T = withContext(Dispatchers.IO) {
        transaction {
            block()
        }
    }

    fun <T : Any> Transaction.queryList(
        query: String,
        parameters: Map<String, Any?>,
        transform: (ResultSet) -> T
    ): List<T> {
        val statement = NamedParameterPreparedStatement.createNamedParameterPreparedStatement(connection, query)
        statement.setParameters(parameters)
        val result = arrayListOf<T>()
        val resultSet = statement.executeQuery()
        resultSet.use {
            while (resultSet.next()) {
                result += transform(resultSet)
            }
        }
        return result
    }

    fun <T : Any> Transaction.queryObject(
        query: String,
        parameters: Map<String, Any?>,
        transform: (ResultSet) -> T
    ): T? {
        val statement = NamedParameterPreparedStatement.createNamedParameterPreparedStatement(connection, query)
        statement.setParameters(parameters)
        val resultSet = statement.executeQuery()
        resultSet.use {
            if (resultSet.next()) {
                return transform(resultSet)
            }
        }
        return null
    }

    private fun NamedParameterPreparedStatement.setParameters(parameters: Map<String, Any?>) {
        parameters.forEach { key, value ->
            when (value) {
                null -> setNull(key, Types.NULL)
                is String -> setString(key, value)
                is Boolean -> setBoolean(key, value)
                is Int -> setInt(key, value)
                is Byte -> setByte(key, value)
                is Long -> setLong(key, value)
                is Short -> setShort(key, value)
                is Float -> setFloat(key, value)
                is Double -> setDouble(key, value.toFloat())
                is BigDecimal -> setBigDecimal(key, value)
                is Date -> setDate(key, value)
                is Time -> setTime(key, value)
                is Timestamp -> setTimestamp(key, value)
                is ByteArray -> setBytes(key, value)
                else -> setObject(key, value)
            }
        }
    }
}

