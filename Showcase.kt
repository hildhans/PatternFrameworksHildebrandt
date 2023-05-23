package com.example

import io.kvision.*
import io.kvision.core.Border
import io.kvision.core.BorderStyle
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.Overflow
import io.kvision.core.onEvent
import io.kvision.form.select.tomSelect
import io.kvision.i18n.DefaultI18nManager
import io.kvision.i18n.I18n
import io.kvision.i18n.I18n.tr
import io.kvision.pace.Pace
import io.kvision.panel.root
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.routing.Routing
import io.kvision.utils.auto
import io.kvision.utils.perc
import io.kvision.utils.px

class Showcase : Application() {
    init {
        Routing.init()
        Pace.init()
        require("css/showcase.css")
        require("react-awesome-button/dist/themes/theme-blue.css")
        if (!(I18n.language in listOf("en", "pl"))) {
            I18n.language = "en"
        }
    }

    override fun start() {
        I18n.manager =
            DefaultI18nManager(
                mapOf(
                    "pl" to require("i18n/messages-pl.json"),
                    "en" to require("i18n/messages-en.json")
                )
            )
        root("showcase") {
            vPanel {
                width = 100.perc
                tabPanel(scrollableTabs = true) {
                    width = 80.perc
                    margin = 20.px
                    marginLeft = auto
                    marginRight = auto
                    padding = 20.px
                    overflow = Overflow.HIDDEN
                    border = Border(2.px, BorderStyle.SOLID, Color.name(Col.SILVER))
                    tab(tr("PoodleStartseite"),  route = "/test") {
                        add(PoodleStartseite())
                    }

                }

            }
        }
    }
}

fun main() {
    startApplication(
        ::Showcase,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        FontAwesomeModule,
        DatetimeModule,
        TomSelectModule,
        BootstrapUploadModule,
        RichTextModule,
        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        ImaskModule,
        ToastifyModule,
        CoreModule
    )
}
