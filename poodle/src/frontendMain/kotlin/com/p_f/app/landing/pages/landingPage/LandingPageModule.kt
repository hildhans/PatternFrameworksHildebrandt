package com.p_f.app.landing.pages.landingPage

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val landingPageModule = module {
    factoryOf(::LandingPageEventHandler)
    factoryOf(::LandingPageViewModel)
}