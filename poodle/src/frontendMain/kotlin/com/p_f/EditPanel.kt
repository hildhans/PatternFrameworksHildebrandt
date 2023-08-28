package com.p_f

import io.kvision.panel.*
import io.kvision.utils.px

object EditPanel : SimplePanel(){
    init {
        this.marginTop = 0.px
        this.minHeight = 400.px
        vPanel(spacing = 5) {
            add(UserPanel)
            add(UserSettingPanel)
        }
    }
}
