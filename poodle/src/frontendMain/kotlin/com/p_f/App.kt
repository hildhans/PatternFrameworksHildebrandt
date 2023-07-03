package com.p_f

import io.kvision.*
import io.kvision.i18n.DefaultI18nManager
import io.kvision.i18n.I18n
import io.kvision.panel.root
import io.kvision.utils.perc
import io.kvision.utils.vh
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {
    init {
        require("css/poodle.css")
    }

    override fun start() {
        I18n.manager =
            DefaultI18nManager(
                mapOf(
                    "en" to require("i18n/messages-en.json")
                )
            )
        root("poodle") {
            //https://kvision.gitbook.io/kvision-guide/v/kvision-1.x/part-1-fundamentals/layout-containers
            //splitPanel(direction = Direction.HORIZONTAL) {
            //splitPanel {
                width = 100.perc
                height = 100.vh
                add(PoodlePanel)
                //add(MainPoodlePanel)
            //}
        }
        AppScope.launch {
            Model.registerUser(Model.firstUser.value, "Test_12345")
            Model.readUser()
        }
    }
}

fun main() {
    startApplication(::App, module.hot, BootstrapModule, FontAwesomeModule, CoreModule)
}
