package com.p_f


import io.kvision.core.*
import io.kvision.html.Tag
import io.kvision.html.div
import io.kvision.utils.px

fun Container.startPart(value: String): Tag {
    return div(value).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.MISTYROSE))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px

        //add(lessonsSlider(""))
        //add(aufgabenPool(""))
    }
}