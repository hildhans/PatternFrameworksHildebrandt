package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.panel.flexPanel
import io.kvision.utils.px

fun Container.mainPart() {

    flexPanel(
        FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.FLEXSTART, AlignItems.CENTER,
        spacing = 5
    ) {
        add(sideBar(""), order = 1)
        add(taskBackground(""), order = 2)
    }
}


fun Container.sideBar(value: String): Tag {
    return div(value).apply {
        align = Align.CENTER
        background = Background(Color.name(Col.LIGHTGREEN))
        width = 300.px
        height = 600.px
        marginTop = 60.px
        marginLeft = 0.px



        button(I18n.tr("Übersicht"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 50.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
        }

        button(I18n.tr("Lektionen"), style = ButtonStyle.INFO) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
        }

        button(I18n.tr("Einstellungen"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
        }

    }
}


