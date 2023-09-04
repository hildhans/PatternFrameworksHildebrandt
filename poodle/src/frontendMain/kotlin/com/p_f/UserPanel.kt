package com.p_f

import io.kvision.core.*
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.i18n.I18n
import io.kvision.panel.HPanel
import io.kvision.panel.hPanel
import io.kvision.utils.px

object UserPanel : HPanel(justify = JustifyContent.SPACEAROUND, alignItems = AlignItems.CENTER, spacing = 10) {
    init {
        hPanel(spacing = 10) {
            button(I18n.tr("Benutzer hinzufügen"), style = ButtonStyle.OUTLINEDARK) {
                background = Background(Color.name(Col.MISTYROSE))
                width = 250.px
                marginTop = 20.px
                fontSize = 15.px
                fontFamily = "Arial"
                onClick {
                    UserSettingPanel.add()
                }
            }

            button(I18n.tr("Passwortänderung"), style = ButtonStyle.OUTLINEDARK) {
                background = Background(Color.name(Col.MISTYROSE))
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
