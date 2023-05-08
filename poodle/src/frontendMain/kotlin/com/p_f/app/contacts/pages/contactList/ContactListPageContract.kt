package com.p_f.app.contacts.pages.contactList

import com.p_f.dto.ContactDto

object ContactListPageContract {
    data class State(
        val loading: Boolean = false,
        val contacts: List<ContactDto> = listOf()
    )

    sealed class Inputs {
        data class LoadedContacts(val contacts: List<ContactDto>) : Inputs()
        object RefreshContacts : Inputs()
        object NavigateToContactAddPage : Inputs()
        data class NavigateToContactDetailPage(val contactUid: String) : Inputs()
        data class SuccessMessage(val message: String) : Inputs()
        data class ErrorMessage(val message: String) : Inputs()
    }

    sealed class Events {
        data class SuccessMessage(val message: String) : Events()
        data class ErrorMessage(val message: String) : Events()
        object NavigateToContactAddPage : Events()
        data class NavigateToContactDetailPage(val contactUid: String) : Events()
    }
}
