package com.p_f


import io.kvision.core.Container
import io.kvision.core.AlignItems
import io.kvision.core.Border
import io.kvision.core.BorderStyle
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.JustifyContent
import io.kvision.html.Align
import io.kvision.html.div
import io.kvision.i18n.I18n.tr
import io.kvision.panel.SimplePanel
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.state.bindEach
import io.kvision.state.observableListOf
import io.kvision.utils.px



class AufgabeZwei : DesktopWindow("Aufgabe 2 Lesson 1", "", 1000, 800) {

    init {
        val englishHello = observableListOf(
            tr("Hello"),

            )

        val germanHallo = observableListOf(
            tr("Hallo")
        )



        hPanel(justify = JustifyContent.CENTER, alignItems = AlignItems.FLEXSTART, useWrappers = true, spacing = 50) {
            vPanel(spacing = 10) {
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.GREEN))
                setDropTargetData("text/xml") { data ->
                    if (data != null) {
                        englishHello.remove(data)
                        germanHallo.add(data)
                    }
                }
            }.bindEach(englishHello) {
                div(it, align = Align.CENTER) {
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/plain", it)
                }
            }

            vPanel(spacing = 10) {
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.BLUE))
                setDropTargetData("text/plain") { data ->
                    if (data != null) {
                        germanHallo.remove(data)
                        englishHello.add(data)
                    }
                }
            }.bindEach(germanHallo) {
                div(it, align = Align.CENTER) {
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/xml", it)
                }
            }

        }

    }


    companion object {
        fun run(container: Container) {
            container.add(AufgabeZwei())
        }
    }
}
