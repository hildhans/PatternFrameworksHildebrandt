package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.panel.FlexPanel
import io.kvision.utils.px

object MainPart : FlexPanel( FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.FLEXSTART, AlignItems.CENTER,
        spacing = 5 ) {
    init{
        add(sideBar(""))
        add(taskBackground(""))
    }
}

fun Container.sideBar(value: String): Tag {
    return div(value).apply {
        align = Align.CENTER
        background = Background(Color.name(Col.PEACHPUFF))
        width = 300.px
        height = 600.px
        marginTop = 60.px
        marginLeft = 0.px
        onClick{
            MainPart.removeAll()
            refresh()
            MainPart.refresh()
            MainPart.add(sideBar(""))
            MainPart.add(taskBackground(""))
            refresh()
        }
        button(I18n.tr("Lektionen"), style = ButtonStyle.OUTLINEDARK) {
            width = 250.px
            marginTop = 50.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.MISTYROSE))
            onClick{
                MainPart.remove(taskBackground(""))
                MainPart.removeAll()
                refresh()
                MainPart.refresh()
                MainPart.add(sideBar(""))
                MainPart.add(lessonsTab(""))
                refresh()
            }
        }
        button(I18n.tr("Übersicht"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            onClick{
                MainPart.remove(taskBackground(""))
                MainPart.removeAll()
                refresh()
                MainPart.refresh()
                MainPart.add(sideBar(""))
                MainPart.add(lessonsOverview(""))
                refresh()
            }
        }
        button(I18n.tr("Einstellungen"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            onClick{
                MainPart.remove(taskBackground(""))
                MainPart.removeAll()
                refresh()
                MainPart.refresh()
                MainPart.add(sideBar(""))
                MainPart.add(configurationContainer(""))
                refresh()
            }
        }
    }
}


