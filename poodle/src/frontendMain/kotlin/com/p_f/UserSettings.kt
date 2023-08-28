package com.p_f

import io.kvision.utils.perc
import io.kvision.utils.vh
import io.kvision.panel.SimplePanel
import io.kvision.panel.splitPanel
import io.kvision.panel.vPanel
import io.kvision.utils.px

object UserSettings : SimplePanel(){
    init {
        this.marginTop = 0.px
        this.minHeight = 400.px
        vPanel(spacing = 5) {
            add(MainMenu)
            add(
                splitPanel {
                    width = 100.perc
                    height = 100.vh
                    add(UserAddress)
                    add(EditPanel)
                }
            )
        }
    }
}