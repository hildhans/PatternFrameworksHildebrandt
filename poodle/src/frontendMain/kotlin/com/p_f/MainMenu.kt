package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.panel.HPanel
import io.kvision.state.bind
import io.kvision.utils.auto
import io.kvision.utils.px

object MainMenu : HPanel(justify = JustifyContent.SPACEAROUND, alignItems = AlignItems.CENTER) {
    init {
        div().bind(Model.user) { user ->
            if (user.name != null) {
                LogoDiv("", 100)
            }
        }
        div().bind(Model.user) { user ->
            if (user.name != null) {
                BegruessungsDiv("${user.name}", 150)
            }
        }
        logoPoodle("", 150)
        LektionShowDiv("", 200)
        FlaggeDiv("", 150)

        //BegruessungsDiv("", 150)
        //welcomeScreen("", 150)

        ProfilBildDiv("", 150)
        add(ActionPanel)
    }
}

fun Container.LogoDiv(value: String, size: Int) {
    div{
        image(io.kvision.require("img/logoPoodle.png")) {
            alignContent = AlignContent.CENTER
            width =  auto
            height = auto
            maxWidth = 200.px
        }
    }
}

fun Container.LektionShowDiv(value: String, size: Int) {
    div {
        marginTop = 40.px
        align = Align.CENTER
        //alignContent = AlignContent.CENTER
        //width = size.px
        //height = size.px
        span(I18n.tr("Lesson 1")){
            fontFamily = "Arial"
            fontSize = 25.px
            fontWeight = FontWeight.BOLDER
            fontVariant = FontVariant.SMALLCAPS
        }
    }
}

fun Container.BegruessungsDiv(value: String, size: Int) {
    div {
        marginTop = 40.px
        align = Align.CENTER
        //width = 400.px
        //height = 50.px
        span(I18n.tr("Hello " + value)) {
            fontFamily = "Arial"
            fontSize = 22.px
            fontStyle = FontStyle.OBLIQUE
            fontWeight = FontWeight.BOLDER
            //fontVariant = FontVariant.SMALLCAPS
        }
    }
}

fun Container.FlaggeDiv(value: String, size: Int) {
    div{
        image(io.kvision.require("img/GB.png")) {
            marginTop = 40.px
            alignContent = AlignContent.CENTER
            width = auto
            height = 100.px
        }
    }
}

fun Container.logoPoodle(value: String, size: Int) {
    div{
        image(io.kvision.require("img/logoPoodle.png")) {
            marginTop = 40.px
            alignContent = AlignContent.CENTER
            width = auto
            height = 100.px
        }
    }
}

fun Container.ProfilBildDiv(value: String, size: Int) {
    div{
        image(io.kvision.require("img/ProfilPic.png")) {
            marginTop = 40.px
            marginLeft = 40.px
            alignContent = AlignContent.CENTER
            width = auto
            height = 75.px
        }
    }
}
