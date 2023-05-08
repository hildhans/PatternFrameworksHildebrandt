package com.p_f.app.auth.pages

import com.p_f.app.auth.pages.login.loginPageModule
import com.p_f.app.auth.pages.register.signupPageModule
import org.koin.dsl.module

val authModule = module {
    includes(loginPageModule, signupPageModule)
}