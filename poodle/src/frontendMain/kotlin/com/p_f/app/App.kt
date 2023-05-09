package com.p_f.app

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.core.JsConsoleBallastLogger
import com.copperleaf.ballast.core.LoggingInterceptor
import com.copperleaf.ballast.plusAssign
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.bus.EventBusImpl
import com.p_f.AppScope
import com.p_f.api.endpointModule
import com.p_f.app.auth.pages.authModule
import com.p_f.app.contacts.pages.contactModule
import com.p_f.app.landing.pages.landingPage.landingPageModule
import com.p_f.app.showKvision.pages.showPage.showKvisionPageModule
import com.p_f.app.layout.appLayoutModule
import com.p_f.app.layout.shared.sharedComponentsModule
import com.p_f.repository.repositoryModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initializeKoin() {
    val appModule = module {
        // Global Coroutine Scope (JavaScript is single-threaded, so...)
        single { AppScope }

        // Ballast Configuration
        factory {
            BallastViewModelConfiguration.Builder().apply {
                this += LoggingInterceptor()
                logger = { JsConsoleBallastLogger(it) }
            }
        }

        // Ballast EventBus for Repositories
        single<EventBus> { EventBusImpl() }

        // Import all modules...
        includes(
            endpointModule,
            routerModule,
            repositoryModule,
            sharedComponentsModule,
            appLayoutModule,
            landingPageModule,
            authModule,
            contactModule,
            showKvisionPageModule
        )
    }

    startKoin {
        modules(appModule)
    }
}