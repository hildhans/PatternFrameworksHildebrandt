package com.example

import io.kvision.core.*
import io.kvision.html.Tag
import io.kvision.html.div
import io.kvision.utils.px


fun Container.taskBackground(value: String): Tag {
    return div(value).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.LIGHTGRAY))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px

        add(aufgabenPool(""))


    }
}
