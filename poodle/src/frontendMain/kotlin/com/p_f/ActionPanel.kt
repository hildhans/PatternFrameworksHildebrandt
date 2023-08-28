package com.p_f

import io.kvision.core.AlignContent
import io.kvision.core.AlignItems
import io.kvision.core.JustifyContent
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.panel.HPanel
import io.kvision.modal.Alert
import io.kvision.panel.hPanel
import io.kvision.state.bind
import io.kvision.utils.px
import kotlinx.browser.document

object ActionPanel : HPanel(justify = JustifyContent.SPACEAROUND, alignItems = AlignItems.CENTER, spacing = 10) {
    init {
        hPanel(spacing = 10) {
            button(I18n.tr(""), "fas fa-home fa-2xl", style = ButtonStyle.LIGHT) {
                alignContent = AlignContent.CENTER
                width =  60.px// @ToDo nur UserAddresse
                height = 60.px// @ToDo nur UserAddresse
                onClick {
                    PoodlePanel.remove(UserSettings)
                    PoodlePanel.removeAll()
                    refresh()
                    PoodlePanel.refresh()
                    PoodlePanel.add(MainMenu)
                    PoodlePanel.add(MainPart)
                    refresh()
                }
            }

            button(I18n.tr(""), "fas fa-bell fa-2xl", style = ButtonStyle.LIGHT, className = "Messages") {
                alignContent = AlignContent.CENTER
                width =  60.px// @ToDo
                height = 60.px// @ToDo
                onClick {
                    Alert.show( I18n.tr("Placeholder"),
                        animation = false )
                }
            }

            button(I18n.tr(""), "fas fa-gear fa-2xl", style = ButtonStyle.LIGHT, className = "UserSettings") {
                alignContent = AlignContent.CENTER
                width =  60.px// @ToDo
                height = 60.px// @ToDo icon button https://www.w3schools.com/icons/icons_reference.asp
                onClick {
                    PoodlePanel.remove(MainPart)
                    PoodlePanel.removeAll()
                    refresh()
                    PoodlePanel.refresh()
                    PoodlePanel.add(MainMenu)
                    PoodlePanel.add(UserSettings)
                    refresh()
                }
            }

            div().bind(Model.user) { user ->
                if (user.name != null) {
                    button(I18n.tr(""), "fas fa-power-off fa-2xl", style = ButtonStyle.LIGHT) {
                        alignContent = AlignContent.CENTER
                        height = 60.px
                        width =  60.px// @ToDo
                        onClick {
                            document.location?.href = "/logout"
                        }
                    }
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
