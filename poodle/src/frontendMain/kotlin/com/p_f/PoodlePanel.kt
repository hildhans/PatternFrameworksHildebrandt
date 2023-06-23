package com.p_f

import io.kvision.core.Container
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.navbar.nav
import io.kvision.navbar.navLink
import io.kvision.navbar.navbar
import io.kvision.panel.SimplePanel
import io.kvision.panel.vPanel
import io.kvision.state.bind
import io.kvision.utils.px
import kotlinx.browser.document

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



