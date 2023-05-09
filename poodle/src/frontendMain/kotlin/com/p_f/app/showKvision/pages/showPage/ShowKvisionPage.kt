package com.p_f.app.showKvision.pages.showPage

import com.p_f.app.layout.mainLayout.mainLayout
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.pace.Pace
import io.kvision.routing.Routing
import io.kvision.state.bind
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import io.kvision.*
import io.kvision.form.select.tomSelect
import io.kvision.i18n.DefaultI18nManager
import io.kvision.utils.auto
import io.kvision.utils.perc
import io.kvision.utils.px
import com.p_f.app.showKvision.pages.showKvision.BasicTab
import com.p_f.app.showKvision.pages.showKvision.ButtonsTab
import com.p_f.app.showKvision.pages.showKvision.ChartTab
import com.p_f.app.showKvision.pages.showKvision.ContainersTab
import com.p_f.app.showKvision.pages.showKvision.DataTab
import com.p_f.app.showKvision.pages.showKvision.DragDropTab
import com.p_f.app.showKvision.pages.showKvision.DropDownTab
import com.p_f.app.showKvision.pages.showKvision.FormTab
import com.p_f.app.showKvision.pages.showKvision.LayoutsTab
import com.p_f.app.showKvision.pages.showKvision.ModalsTab
import com.p_f.app.showKvision.pages.showKvision.RestTab
import com.p_f.app.showKvision.pages.showKvision.TabulatorTab
import io.kvision.core.*
import io.kvision.panel.*

fun Container.ShowKvisionPage() : KoinComponent = object : KoinComponent {
    val vm by inject<ShowKvisionPageViewModel>()
    
    init {
        mainLayout("Show Kvision ") {
            div {

                div().bind(vm) { state ->
                    if (state.loading) {
                        h4 { +"Loading Information..." }
                    }
                    h3 { +"Welcome" }
                    p { +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce nec fringilla turpis." }

                    div{

                        this.marginTop = 10.px
                        this.minHeight = 400.px
                        Routing.init()
                        Pace.init()
                        require("css/showcase.css")
                        require("react-awesome-button/dist/themes/theme-blue.css")
                        if (!(I18n.language in listOf("en", "pl"))) {
                            I18n.language = "en"
                        }
                        I18n.manager =
                            DefaultI18nManager(
                                mapOf(
                                    "pl" to require("i18n/messages-pl.json"),
                                    "en" to require("i18n/messages-en.json")
                                )
                            )
                        vPanel(spacing = 5) {
                            tabPanel(scrollableTabs = true, draggableTabs = true) {
                                width = 100.perc
                                margin = 20.px
                                marginLeft = auto
                                marginRight = auto
                                padding = 20.px
                                overflow = Overflow.HIDDEN
                                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.SILVER))
                                tab(I18n.tr("HTML"), "fas fa-bars", route = "/basic") {
                                    div("&nbsp;", rich = true) {
                                        add(BasicTab())
                                    }
                                }
                                tab(I18n.tr("Forms"), "fas fa-edit", route = "/forms") {
                                    div("&nbsp;", rich = true) {
                                        add(FormTab())
                                    }
                                }
                                tab(I18n.tr("Buttons"), "far fa-check-square", route = "/buttons") {
                                    div("&nbsp;", rich = true) {
                                        add(ButtonsTab())
                                    }
                                }
                                tab(I18n.tr("Dropdowns"), "fas fa-arrow-down", route = "/dropdowns") {
                                    div("&nbsp;", rich = true) {
                                        add(DropDownTab())
                                    }
                                }
                                tab(I18n.tr("Containers"), "fas fa-database", route = "/containers") {
                                    div("&nbsp;", rich = true) {
                                        add(ContainersTab())
                                    }
                                }
                                tab(I18n.tr("Layouts"), "fas fa-th-list", route = "/layouts") {
                                    div("&nbsp;", rich = true) {
                                        add(LayoutsTab())
                                    }
                                }
                                tab(I18n.tr("Windows"), "fas fa-window-maximize", route = "/windows") {
                                    div("&nbsp;", rich = true) {
                                        add(ModalsTab())
                                    }
                                }
                                tab(I18n.tr("Data binding"), "fas fa-retweet", route = "/data") {
                                    div("&nbsp;", rich = true) {
                                        add(DataTab())
                                    }
                                }
                                tab(I18n.tr("Drag & Drop"), "fas fa-arrows-alt", route = "/dragdrop") {
                                    div("&nbsp;", rich = true) {
                                        add(DragDropTab())
                                    }
                                }
                                tab(I18n.tr("Charts"), "far fa-chart-bar", route = "/charts") {
                                    div("&nbsp;", rich = true) {
                                        add(ChartTab())
                                    }
                                }
                                tab(I18n.tr("Tables"), "fas fa-table", route = "/tabulator") {
                                    div("&nbsp;", rich = true) {
                                        add(TabulatorTab())
                                    }
                                }
                                tab(I18n.tr("RESTful"), "fas fa-plug", route = "/restful") {
                                    div("&nbsp;", rich = true) {
                                        add(RestTab())
                                    }
                                }
                            }
                            tomSelect(listOf("en" to I18n.tr("English"), "pl" to I18n.tr("Polish")), I18n.language) {
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
                }
            }
        }
    }
}