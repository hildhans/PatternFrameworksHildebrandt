package com.p_f


import com.p_f.Lessons.*
import io.kvision.core.*
import io.kvision.html.Align
import io.kvision.html.Tag
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.flexPanel
import io.kvision.toolbar.buttonGroup
import io.kvision.toolbar.toolbar
import io.kvision.utils.perc
import io.kvision.utils.px

fun Container.lessonsTab(value: String): Tag {
    return div(value).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.LIGHTGRAY))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px

        add(lessonsSlider(""))


    }
}