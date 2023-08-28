package com.p_f

import io.kvision.panel.SimplePanel
import io.kvision.panel.vPanel
import io.kvision.utils.px

object PoodlePanel : SimplePanel(){
    init {
        this.marginTop = 0.px
        this.minHeight = 400.px
        vPanel(spacing = 5) {
            add(MainMenu)
            add(MainPart)
        }
    }
}



