package com.p_f

import com.p_f.Model.user
import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.hPanel
import io.kvision.state.bind
import io.kvision.utils.auto
import io.kvision.utils.px


fun Container.menuBar() {
    hPanel(spacing = 10) {
        LogoDiv("", 100)
        BegruessungsDiv("", 150)
        LektionShowDiv("", 200)
        FlaggeDiv("", 150)
        ProfilBildDiv("", 150)
    }
}

fun Container.LogoDiv(value: String, size: Int): Tag {
    return div(value).apply {
        image(io.kvision.require("img/logoPoodle.png")) {
            alignContent = AlignContent.CENTER
            width =  auto
            height = auto
            maxWidth = 200.px
        }
    }
}

fun Container.LektionShowDiv(value: String, size: Int): Tag {
    return div(value).apply {
        marginTop = 40.px
        align = Align.CENTER
        alignContent = AlignContent.CENTER
        width = size.px
        height = size.px
        span {
            fontFamily = "Arial"
            fontSize = 20.px
            fontWeight = FontWeight.BOLDER
            fontVariant = FontVariant.SMALLCAPS
            +io.kvision.i18n.tr("Lektion 1")
        }
    }
}

fun Container.BegruessungsDiv(value: String, size: Int): Tag {
    return div(value).apply {
        marginTop = 40.px
        align = Align.CENTER
        width = 400.px
        height = 50.px
        span {
            fontFamily = "Arial"
            fontSize = 22.px
            fontStyle = FontStyle.OBLIQUE
            fontWeight = FontWeight.BOLDER
            fontVariant = FontVariant.SMALLCAPS
            +io.kvision.i18n.tr("Hello")
        }

        div(rich = true) {
            +io.kvision.i18n.tr("<span style=\"font-family: Verdana; font-size: 14pt\">Du machst das großartig. Weiter so!</span>")
        }
    }
}

fun Container.FlaggeDiv(value: String, size: Int): Tag {
    return div(value).apply {
        image(io.kvision.require("img/GB.png")) {
            marginTop = 40.px
            alignContent = AlignContent.CENTER
            width =  auto
            height = 100.px

        }
    }
}

fun Container.ProfilBildDiv(value: String, size: Int): Tag {
    return div(value).apply {
        image(io.kvision.require("img/ProfilPic.png")) {
            marginTop = 40.px
            marginLeft = 40.px
            alignContent = AlignContent.CENTER
            width =  auto
            height = 100.px

        }
    }
}

