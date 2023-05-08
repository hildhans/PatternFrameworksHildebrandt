package com.p_f.app.auth.pages.login

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val loginPageModule = module {
    factoryOf(::LoginPageInputHandler)
    factoryOf(::LoginPageEventHandler)
    factoryOf(::LoginPageViewModel)
}