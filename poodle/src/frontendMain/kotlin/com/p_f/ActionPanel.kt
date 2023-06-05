package com.example

import com.p_f.Model
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.StackPanel
import io.kvision.state.bind
import kotlinx.browser.document

object ActionPanel : StackPanel() {

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
