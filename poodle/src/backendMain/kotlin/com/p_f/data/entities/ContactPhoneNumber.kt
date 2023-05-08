package com.p_f.data.entities

import com.p_f.dto.ContactPhoneNumberDto
import com.p_f.dto.UpdateContactPhoneNumberDto
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

object ContactPhoneNumberTable : IntIdTable("contact_phone_numbers") {
    val phoneNumber = varchar("phone_number", 30)
    val contact_uid = reference("contact_uid", ContactTable.uid)
}

fun ResultRow.toContactPhoneNumberDto() = ContactPhoneNumberDto(
    phoneNumber = this[ContactPhoneNumberTable.phoneNumber],
    contactUid = this[ContactPhoneNumberTable.contact_uid]
)