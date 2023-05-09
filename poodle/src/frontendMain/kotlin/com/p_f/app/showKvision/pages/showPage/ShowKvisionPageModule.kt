package com.p_f.app.showKvision.pages.showPage

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val showKvisionPageModule = module {
    factoryOf(::ShowKvisionPageInputHandler)
    factoryOf(::ShowKvisionPageEventHandler)
    factoryOf(::ShowKvisionPageViewModel)
}