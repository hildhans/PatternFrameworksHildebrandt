package com.p_f

import com.p_f.Db.dbQuery
import com.p_f.Db.queryList
import com.github.andrewoma.kwery.core.builder.query
import io.ktor.server.application.*
import io.ktor.server.sessions.*
import org.apache.commons.codec.digest.DigestUtils
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import org.joda.time.DateTime
import java.sql.ResultSet
import java.time.ZoneId

suspend fun <RESP> ApplicationCall.withProfile(block: suspend (Profile) -> RESP): RESP {
    val profile = this.sessions.get<Profile>()
    return profile?.let {
        block(profile)
    } ?: throw IllegalStateException("Profil wurde nicht gesetzt!")
}

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class UserService(private val call: ApplicationCall) : IUserService {

    override suspend fun getUser() = call.withProfile { it  }

    override suspend fun deleteUser(id: Int): Boolean = call.withProfile { profile ->
        dbQuery {
            UserDao.deleteWhere { (UserDao.id eq profile.id!!) and (UserDao.id eq id) } > 0
        }
    }
}
@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class ProfileService(private val call: ApplicationCall) : IProfileService {

    override suspend fun getProfile() = call.withProfile { it }

}

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class RegisterProfileService : IRegisterProfileService {

    override suspend fun registerProfile(profile: Profile, password: String): Boolean {
        try {
            dbQuery {
                UserDao.insert {
                    it[this.name] = profile.name!!
                    it[this.username] = profile.username!!
                    it[this.password] = DigestUtils.sha256Hex(password)
                }
            }
        } catch (e: Exception) {
            throw Exception("Register operation failed!")
        }
        return true
    }

}
