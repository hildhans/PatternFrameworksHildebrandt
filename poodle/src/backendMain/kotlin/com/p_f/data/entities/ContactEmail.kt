package com.p_f.data.entities

import com.p_f.dto.ContactEmailDto
import com.p_f.dto.UpdateContactEmailDto
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

object ContactEmailTable : IntIdTable("contact_emails") {
    val email = varchar("email", 180)
    val contact_uid = reference("contact_uid", ContactTable.uid)
}

fun ResultRow.toContactEmailDto() = ContactEmailDto(
    email = this[ContactEmailTable.email],
    contactUid = this[ContactEmailTable.contact_uid]
)