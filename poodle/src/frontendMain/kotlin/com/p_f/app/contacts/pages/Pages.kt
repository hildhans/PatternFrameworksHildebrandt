package com.p_f.app.contacts.pages

import com.p_f.app.contacts.pages.contactAdd.contactAddPageModule
import com.p_f.app.contacts.pages.contactDetail.contactDetailPageModule
import com.p_f.app.contacts.pages.contactList.contactListPageModule
import org.koin.dsl.module

val contactModule = module {
    includes(contactListPageModule, contactAddPageModule, contactDetailPageModule)
}