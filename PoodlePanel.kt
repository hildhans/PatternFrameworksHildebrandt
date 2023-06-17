package com.example


import io.kvision.i18n.I18n
import io.kvision.navbar.nav
import io.kvision.navbar.navLink
import io.kvision.navbar.navbar
import io.kvision.panel.SimplePanel
import io.kvision.panel.vPanel
import io.kvision.utils.px



object PoodlePanel : SimplePanel(){
    init {
        this.marginTop = 0.px
        this.minHeight = 400.px
        vPanel(spacing = 5) {
            navbar("", collapseOnClick = true) {
                nav {
                    menuBar()
                }
                nav(rightAlign = true) {
                    navLink(I18n.tr(""), icon = "fas fa-home fa-2xl")
                    navLink(I18n.tr(""), icon = "fas fa-bell fa-2xl")
                    navLink(I18n.tr(""), icon = "fas fa-power-off fa-2xl")
                }
            }
            mainPart()
        }
    }



}



