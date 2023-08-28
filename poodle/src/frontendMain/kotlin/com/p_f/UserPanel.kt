package com.p_f

import io.kvision.core.AlignItems
import io.kvision.core.JustifyContent
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.i18n.I18n
import io.kvision.panel.HPanel
import io.kvision.panel.hPanel
import io.kvision.utils.px

object UserPanel : HPanel(justify = JustifyContent.SPACEAROUND, alignItems = AlignItems.CENTER, spacing = 10) {
    init {
        hPanel(spacing = 10) {
            button(I18n.tr("Add User/Address"), style = ButtonStyle.LIGHT) {
                width = 250.px
                marginTop = 20.px
                fontSize = 15.px
                fontFamily = "Arial"
                onClick {
                    UserSettingPanel.add()
                }
            }

            button(I18n.tr("Change Password"), style = ButtonStyle.LIGHT) {
                width = 250.px
                marginTop = 20.px
                fontSize = 15.px
                fontFamily = "Arial"
                onClick {
                    UserSettingPanel.change()
                }
            }
        }
    }
}
