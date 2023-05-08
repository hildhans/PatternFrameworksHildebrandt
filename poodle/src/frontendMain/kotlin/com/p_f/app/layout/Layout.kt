package com.p_f.app.layout

import com.p_f.app.layout.mainLayout.mainLayoutModule
import org.koin.dsl.module

val appLayoutModule = module {
    includes(mainLayoutModule)
}