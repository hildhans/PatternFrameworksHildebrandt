package com.p_f

import com.p_f.Db.dbQuery
import com.p_f.Db.queryList
import com.github.andrewoma.kwery.core.builder.query
import io.ktor.server.application.*
import io.ktor.server.sessions.*
import org.apache.commons.codec.digest.DigestUtils
import org.jetbrains.exposed.sql.*
import org.joda.time.DateTime
import java.sql.ResultSet
import java.time.ZoneId

suspend fun <RESP> ApplicationCall.withUser(block: suspend (User) -> RESP): RESP {
    val user = this.sessions.get<User>()
    return user?.let {
        block(user)
    } ?: throw IllegalStateException("Profil wurde nicht gesetzt!")
}

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class UserAddressService(private val call: ApplicationCall) : IUserAddressService {

    override suspend fun getUserAddressList(search: String?, types: String, sort: Sort) = call.withUser { user ->
            dbQuery {
                val query = query {
                    select("SELECT * FROM address")
                    whereGroup {
                        where("user_id = :user_id")
                        parameter("user_id", user.id)
                        search?.let {
                            where(
                                """(lower(first_name) like :search
                            OR lower(last_name) like :search
                            OR lower(email) like :search
                            OR lower(phone) like :search
                            OR lower(postal_address) like :search)""".trimMargin()
                            )
                            parameter("search", "%${it.lowercase()}%")
                        }
                        if (types == "fav") {
                            where("favourite")
                        }
                    }
                    when (sort) {
                        Sort.FN -> orderBy("lower(first_name)")
                        Sort.LN -> orderBy("lower(last_name)")
                        Sort.E -> orderBy("lower(email)")
                        Sort.F -> orderBy("favourite")
                    }
                }
                queryList(query.sql, query.parameters) {
                    toUserAddress(it)
                }
            }
        }

    override suspend fun addUserAddress(address: Address) = call.withUser { user ->
        val key = dbQuery {
            (UserAddressDbo.insert {
                it[firstName] = address.firstName
                it[lastName] = address.lastName
                it[email] = address.email
                it[phone] = address.phone
                it[postalAddress] = address.postalAddress
                it[bio] = address.bio
                it[userimage] = address.userimage
                it[createdAt] = DateTime()
                it[userId] = address.id!!

            } get UserAddressDbo.id)
        }
        getUserAddress(key)!!
    }

    override suspend fun updateUserAddress(address: Address) = call.withUser { user ->
        address.id?.let {
            getUserAddress(it)?.let { oldUserAddress ->
                dbQuery {
                    UserAddressDbo.update({ UserAddressDbo.id eq it }) {
                        it[firstName] = address.firstName
                        it[lastName] = address.lastName
                        it[email] = address.email
                        it[phone] = address.phone
                        it[postalAddress] = address.postalAddress
                        it[bio] = address.bio
                        it[userimage] = address.userimage
                        it[createdAt] = oldUserAddress.createdAt
                            ?.let { DateTime(java.util.Date.from(it.atZone(ZoneId.systemDefault()).toInstant())) }
                        it[userId] = user.id!!
                    }
                }
            }
            getUserAddress(it)
        } ?: throw IllegalArgumentException("The ID of the address not set")
    }

    override suspend fun deleteUserAddress(id: Int): Boolean = call.withUser { user ->
        dbQuery {
            UserAddressDbo.deleteWhere { (UserAddressDbo.userId eq user.id!!) and (UserAddressDbo.id eq id) } > 0
        }
    }

    private suspend fun getUserAddress(id: Int): Address? = dbQuery {
        UserAddressDbo.select {
            UserAddressDbo.id eq id
        }.mapNotNull { toUserAddress(it) }.singleOrNull()
    }

    private fun toUserAddress(row: ResultRow): Address =
        Address(
            id = row[UserAddressDbo.id],
            firstName = row[UserAddressDbo.firstName],
            lastName = row[UserAddressDbo.lastName],
            email = row[UserAddressDbo.email],
            phone = row[UserAddressDbo.phone],
            postalAddress = row[UserAddressDbo.postalAddress],
            bio = row[UserAddressDbo.bio],
            userimage = row[UserAddressDbo.userimage],
            createdAt = row[UserAddressDbo.createdAt]?.millis?.let { java.util.Date(it) }?.toInstant()
                ?.atZone(ZoneId.systemDefault())?.toLocalDateTime(),
            userId = row[UserAddressDbo.userId]
        )

    private fun toUserAddress(rs: ResultSet): Address =
        Address(
            id = rs.getInt(UserAddressDbo.id.name),
            firstName = rs.getString(UserAddressDbo.firstName.name),
            lastName = rs.getString(UserAddressDbo.lastName.name),
            email = rs.getString(UserAddressDbo.email.name),
            phone = rs.getString(UserAddressDbo.phone.name),
            postalAddress = rs.getString(UserAddressDbo.postalAddress.name),
            bio = rs.getString(UserAddressDbo.bio.name),
            userimage = rs.getString(UserAddressDbo.userimage.name),
            createdAt = rs.getTimestamp(UserAddressDbo.createdAt.name)?.toInstant()
                ?.atZone(ZoneId.systemDefault())?.toLocalDateTime(),
            userId = rs.getInt(UserAddressDbo.userId.name)
        )

}

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class UserService(private val call: ApplicationCall) : IUserService {

    override suspend fun getUser() = call.withUser { it }

}

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class RegisterUserService : IRegisterUserService {

    override suspend fun registerUser(user: User, password: String): Boolean {
        try {
            dbQuery {
                UserDbo.insert {
                    it[this.name] = user.name!!
                    it[this.username] = user.username!!
                    it[this.password] = DigestUtils.sha256Hex(password)
                }
            }
        } catch (e: Exception) {
            throw Exception("Register operation failed!")
        }
        return true
    }

}
