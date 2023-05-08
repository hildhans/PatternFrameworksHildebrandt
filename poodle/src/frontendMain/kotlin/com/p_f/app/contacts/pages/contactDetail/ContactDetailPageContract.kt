package com.p_f.app.contacts.pages.contactDetail

import com.p_f.dto.ContactDto
import com.p_f.dto.UpdateContactDto

object ContactDetailPageContract {
    data class State(
        val loading: Boolean = false,
        val isEditing: Boolean = false,
        val contact: ContactDto? = null
    )

    sealed class Inputs {
        data class Initialize(val contactUid: String) : Inputs()
        data class SetContact(val contact: ContactDto) : Inputs()
        data class UpdateContact(val contactUid: String, val data: UpdateContactDto) : Inputs()
        data class DeleteContact(val contactUid: String) : Inputs()
        data class SuccessMessage(val message: String) : Inputs()
        data class ErrorMessage(val message: String) : Inputs()
        object EnableEditMode : Inputs()
        object DisableEditMode : Inputs()
    }

    sealed class Events {
        data class SuccessMessage(val message: String) : Events()
        data class ErrorMessage(val message: String) : Events()
        object NavigateToContactDetailPage : Events()
    }
}
