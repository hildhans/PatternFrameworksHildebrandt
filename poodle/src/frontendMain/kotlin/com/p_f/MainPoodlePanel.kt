package com.p_f

import io.kvision.core.JustifyContent
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.HPanel
import io.kvision.state.bind
import kotlinx.browser.document

object MainPoodlePanel : HPanel(justify = JustifyContent.SPACEBETWEEN) {
    init {
        div().bind(Model.profile) { profile ->
            if (profile.name != null) {
                button("Logout: ${profile.name}", "fas fa-sign-out-alt", style = ButtonStyle.WARNING).onClick {
                    document.location?.href = "/logout"
                }
            }
        }
    }
}
