package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.panel.FlexPanel
import io.kvision.utils.px

object MainPart : FlexPanel( FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.FLEXSTART, AlignItems.CENTER,
        spacing = 5 ) {
    init{
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



        button(I18n.tr("Overwiew"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 50.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
        }

        button(I18n.tr("Lessons"), style = ButtonStyle.INFO) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
        }

        button(I18n.tr("Configuration"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
        }

    }
}


