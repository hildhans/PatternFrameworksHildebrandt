package com.p_f

import com.p_f.data.DatabaseFactory
import com.p_f.plugins.configureDI
import com.p_f.plugins.configureRouting
import com.p_f.plugins.configureSecurity
import com.p_f.plugins.loadConfig
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    val appConfig = loadConfig()
    configureDI(appConfig)
    configureSecurity(appConfig.jwt)
    configureRouting()

    // Load database if not using in-memory storage
    if (!appConfig.settings.useInMemoryStorage) {
        DatabaseFactory.init(appConfig.database)
    }

}
