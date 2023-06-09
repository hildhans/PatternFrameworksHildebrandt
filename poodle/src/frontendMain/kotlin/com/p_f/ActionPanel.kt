package com.p_f

import io.kvision.core.JustifyContent
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.HPanel
import io.kvision.i18n.I18n.tr
import io.kvision.state.bind
import kotlinx.browser.document

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
}
