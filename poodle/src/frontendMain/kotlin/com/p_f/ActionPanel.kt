package com.p_f

import io.kvision.core.Container
import io.kvision.core.JustifyContent
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.HPanel
import io.kvision.i18n.I18n.tr
import io.kvision.panel.hPanel
import io.kvision.state.bind
import io.kvision.utils.px
import kotlinx.browser.document

fun Container.actionPanel() {
    hPanel(spacing = 5) {
        button(tr(""), "fas fa-home fa-2xl", style = ButtonStyle.LIGHT).onClick {
            width = 30.px// @ToDo nur UserAddresse
        }

        button(tr(""), "fas fa-bell fa-2xl", style = ButtonStyle.LIGHT).onClick {
            width = 30.px// @Todo
        }

        button(tr(""), "fas fa-gear fa-2xl", style = ButtonStyle.LIGHT).onClick {
            width = 30.px// @ToDo icon button https://www.w3schools.com/icons/icons_reference.asp
        }

        div().bind(Model.user) { user ->
            if (user.name != null) {
                button("${user.name}", "fas fa-power-off fa-2xl", style = ButtonStyle.LIGHT).onClick {
                    width = 30.px
                    document.location?.href = "/logout"
                }
            }
        }
    }
}
/*
object ActionPanel : HPanel(justify = JustifyContent.SPACEBETWEEN) {
    init {
        button(tr("Add Address"), "fas fa-plus", style = ButtonStyle.PRIMARY).onClick {
            MainPoodlePanel.add() // @ToDo nur UserAddresse
        }

        button(tr("Home"), "fas fa-home", style = ButtonStyle.PRIMARY).onClick {
            // @Todo
        }

        button(tr("Notification"), "fas fa-bell", style = ButtonStyle.PRIMARY).onClick {
            // @Todo
        }

        button(tr("Settings"), "fas fa-gear", style = ButtonStyle.PRIMARY).onClick {
            // @ToDo icon button https://www.w3schools.com/icons/icons_reference.asp
        }

        div().bind(Model.user) { user ->
            if (user.name != null) {
                button("Logout: ${user.name}", "fas fa-sign-out-alt", style = ButtonStyle.WARNING).onClick {
                    document.location?.href = "/logout"
                }
            }
        }
    }
}*/
