package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.modal.Alert
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.state.bindEach
import io.kvision.state.observableListOf
import io.kvision.utils.px

fun Container.aufgabenPool(value: String): Tag {
    return div(value).apply {
        fontSize = 15.px
        fontFamily = "DejaVu Sans"

        val wordTrinken = observableListOf(
            I18n.tr("trinken")
        )

        val wordToDrink = observableListOf(
            I18n.tr("to drink")
        )

        hPanel(
            justify = io.kvision.core.JustifyContent.CENTER,
            alignItems = AlignItems.FLEXSTART,
            useWrappers = true,
            spacing = 50
        ) {
            vPanel(spacing = 10) {
                marginTop = 50.px
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/xml") { data ->
                    if (data != null) {
                        wordTrinken.remove(data)
                        wordToDrink.add(data)
                    }
                }
            }.bindEach(wordToDrink) {
                div(it, align = Align.CENTER) {
                    background = Background(Color.name(Col.ROSYBROWN))
                    padding = 3.px
                    setDragDropData("text/plain", it)
                }
            }

            vPanel(spacing = 10) {
                marginTop = 50.px
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/plain") { data ->
                    if (data != null) {
                        wordToDrink.remove(data)
                        wordTrinken.add(data)
                    }
                }
            }.bindEach(wordTrinken) {
                div(it, align = Align.CENTER) {
                    background = Background(Color.name(Col.ROSYBROWN))
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/xml", it)
                }
            }
        }

        val wordTschuess = observableListOf(
            I18n.tr("tschüss")
        )

        val wordBye = observableListOf(
            I18n.tr("bye")
        )

        hPanel(
            justify = io.kvision.core.JustifyContent.CENTER,
            alignItems = AlignItems.FLEXSTART,
            useWrappers = true,
            spacing = 50
        ) {
            vPanel(spacing = 10) {
                marginTop = 14.px
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/xml") { data ->
                    if (data != null) {
                        wordTschuess.remove(data)
                        wordBye.add(data)
                    }
                }
            }.bindEach(wordBye) {
                div(it, align = Align.CENTER) {
                    background = Background(Color.name(Col.ROSYBROWN))
                    padding = 3.px
                    setDragDropData("text/plain", it)
                }
            }

            vPanel(spacing = 10) {
                marginTop = 14.px
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/plain") { data ->
                    if (data != null) {
                        wordBye.remove(data)
                        wordTschuess.add(data)
                    }
                }
            }.bindEach(wordTschuess) {
                div(it, align = Align.CENTER) {
                    background = Background(Color.name(Col.ROSYBROWN))
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/xml", it)
                }
            }

        }

        val wordDanke = observableListOf(
            I18n.tr("Danke")
        )

        val wordThanks = observableListOf(
            I18n.tr("Thanks")
        )

        hPanel(
            justify = io.kvision.core.JustifyContent.CENTER,
            alignItems = AlignItems.FLEXSTART,
            useWrappers = true,
            spacing = 50
        ) {
            vPanel(spacing = 10) {
                marginTop = 14.px
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/xml") { data ->
                    if (data != null) {
                        wordDanke.remove(data)
                        wordThanks.add(data)
                    }
                }
            }.bindEach(wordThanks) {
                div(it, align = Align.CENTER) {
                    background = Background(Color.name(Col.ROSYBROWN))
                    padding = 3.px
                    setDragDropData("text/plain", it)
                }
            }
            vPanel(spacing = 10) {
                marginTop = 14.px
                width = 200.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/plain") { data ->
                    if (data != null) {
                        wordThanks.remove(data)
                        wordDanke.add(data)
                    }
                }
            }.bindEach(wordDanke) {
                div(it, align = Align.CENTER) {
                    background = Background(Color.name(Col.ROSYBROWN))
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/xml", it)
                }
            }
        }
        div(rich = true) {
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Task"), style = ButtonStyle.SECONDARY).onClick {
                Alert.show(
                    I18n.tr("Task: Lesson 1, Exercise 3"),
                    I18n.tr("Put the correct word pairs together."),
                    animation = false )
            }
        }
        div(""){
            marginTop = 60.px
            marginLeft = 180.px
            add(lessonsSlider(""))
        }
    }
}



