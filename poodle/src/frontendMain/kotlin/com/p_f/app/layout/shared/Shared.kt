package com.p_f.app.layout.shared

import com.p_f.app.layout.shared.appHeader.appHeaderModule
import org.koin.dsl.module

val sharedComponentsModule = module {
    includes(appHeaderModule)
}