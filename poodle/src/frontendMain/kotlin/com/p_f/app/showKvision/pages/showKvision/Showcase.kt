package com.p_f.app.showKvision.pages.showKvision

import io.kvision.*
import io.kvision.pace.Pace
import io.kvision.routing.Routing

class Showcase : Application() {
    init {
        Routing.init()
        Pace.init()
        require("css/showcase.css")
        require("react-awesome-button/dist/themes/theme-blue.css")
    }
/*
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
                    tab(tr("HTML"), "fas fa-bars", route = "/basic") {
                        add(BasicTab())
                    }
                    tab(tr("Forms"), "fas fa-edit", route = "/forms") {
                        add(FormTab())
                    }
                    tab(tr("Buttons"), "far fa-check-square", route = "/buttons") {
                        add(ButtonsTab())
                    }
                    tab(tr("Dropdowns"), "fas fa-arrow-down", route = "/dropdowns") {
                        add(DropDownTab())
                    }
                    tab(tr("Containers"), "fas fa-database", route = "/containers") {
                        add(ContainersTab())
                    }
                    tab(tr("Layouts"), "fas fa-th-list", route = "/layouts") {
                        add(LayoutsTab())
                    }
                    tab(tr("Windows"), "fas fa-window-maximize", route = "/windows") {
                        add(ModalsTab())
                    }
                    tab(tr("Data binding"), "fas fa-retweet", route = "/data") {
                        add(DataTab())
                    }
                    tab(tr("Drag & Drop"), "fas fa-arrows-alt", route = "/dragdrop") {
                        add(DragDropTab())
                    }
                    tab(tr("Charts"), "far fa-chart-bar", route = "/charts") {
                        add(ChartTab())
                    }
                    tab(tr("Tables"), "fas fa-table", route = "/tabulator") {
                        add(TabulatorTab())
                    }
                    tab(tr("RESTful"), "fas fa-plug", route = "/restful") {
                        add(RestTab())
                    }
                }
                tomSelect(listOf("en" to tr("English"), "pl" to tr("Polish")), I18n.language) {
                    width = 300.px
                    marginLeft = auto
                    marginRight = auto
                    marginBottom = 100.px
                    onEvent {
                        change = {
                            I18n.language = self.value ?: "en"
                        }
                    }
                }
            }
        }
    }*/
}

