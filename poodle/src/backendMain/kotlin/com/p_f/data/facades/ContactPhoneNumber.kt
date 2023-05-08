package com.p_f.data.facades

import arrow.core.Either
import com.p_f.data.DatabaseFactory.dbQuery
import com.p_f.data.entities.ContactPhoneNumberTable
import com.p_f.data.entities.toContactPhoneNumberDto
import com.p_f.domain.DomainError
import com.p_f.dto.ContactPhoneNumberDto
import com.p_f.dto.UpdateContactPhoneNumberDto
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.select

interface ContactPhoneNumberFacade {
    suspend fun listByContactUid(contactUid: String): Either<DomainError, List<ContactPhoneNumberDto>>
    suspend fun insertByContactUid(contactUid: String, data: List<UpdateContactPhoneNumberDto>): Either<DomainError, Unit>
    suspend fun deleteByContactUid(contactUid: String): Either<DomainError, Unit>
}

object ContactPhoneNumberFacadeDatabaseImpl : ContactPhoneNumberFacade {
    override suspend fun listByContactUid(contactUid: String): Either<DomainError, List<ContactPhoneNumberDto>> {
        return Either.catch {
            dbQuery {
                ContactPhoneNumberTable
                    .select { ContactPhoneNumberTable.contact_uid eq contactUid }
                    .map { it.toContactPhoneNumberDto() }
            }
        }.mapLeft {
            DomainError.DatabaseError(it)
        }
    }

    override suspend fun insertByContactUid(
        contactUid: String,
        data: List<UpdateContactPhoneNumberDto>
    ): Either<DomainError, Unit> {
        return Either.catch {
            dbQuery {
                ContactPhoneNumberTable
                    .batchInsert(data) {
                        this[ContactPhoneNumberTable.phoneNumber] = it.phoneNumber
                        this[ContactPhoneNumberTable.contact_uid] = contactUid
                    }
            }

            Unit
        }.mapLeft {
            DomainError.DatabaseError(it)
        }
    }

    override suspend fun deleteByContactUid(contactUid: String): Either<DomainError, Unit> {
        return Either.catch {
            dbQuery {
                ContactPhoneNumberTable
                    .deleteWhere { ContactPhoneNumberTable.contact_uid eq contactUid }
            }

            Unit
        }.mapLeft {
            DomainError.DatabaseError(it)
        }
    }
}

object ContactPhoneNumberFacadeInMemoryImpl : ContactPhoneNumberFacade {
    private val contactPhoneNumberStore: MutableList<ContactPhoneNumberDto> = mutableListOf()

    override suspend fun listByContactUid(contactUid: String): Either<DomainError, List<ContactPhoneNumberDto>> {
        val contactPhoneNumbers = contactPhoneNumberStore
            .filter { it.contactUid == contactUid }

        return Either.Right(contactPhoneNumbers)
    }

    override suspend fun insertByContactUid(
        contactUid: String,
        data: List<UpdateContactPhoneNumberDto>
    ): Either<DomainError, Unit> {
        contactPhoneNumberStore
            .addAll(data.map {
                ContactPhoneNumberDto(
                    phoneNumber = it.phoneNumber,
                    contactUid = contactUid
                )
            })

        return Either.Right(Unit)
    }

    override suspend fun deleteByContactUid(contactUid: String): Either<DomainError, Unit> {
        contactPhoneNumberStore
            .removeIf { it.contactUid == contactUid }

        return Either.Right(Unit)
    }

}

