package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.modal.Alert
import io.kvision.panel.*
import io.kvision.state.bindEach
import io.kvision.state.observableListOf
import io.kvision.toolbar.buttonGroup
import io.kvision.toolbar.toolbar
import io.kvision.utils.perc
import io.kvision.utils.px

object PoodlePanel : SimplePanel() {

    init {
        this.marginTop = 0.px
        this.minHeight = 400.px
        vPanel(spacing = 5) {
            addRespGridPanel()
        }
    }

    private fun Container.addFlexPanel1() {
        flexPanel(
            FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.CENTER, AlignItems.CENTER,
            spacing = 5
        ) {
            background = Background(Color.name(Col.DARKGRAY))
            FlaggeDiv("", 200)
            BegruessungsDiv("", 0)
            LektionShowDiv("", 200)
            HomeButtonDiv("", 200)
            AlarmButtonDiv("", 200)
            ProfilBildDiv("", 200)
        }
    }

    private fun Container.FlaggeDiv(value: String, size: Int): Tag {
        return div(value).apply {
            align = Align.CENTER
            alignContent = AlignContent.CENTER
            width = size.px
            height = size.px
            image(io.kvision.require("img/GB.png")) {
                marginTop = 25.px
                maxWidth = 40.perc
            }
        }
    }

    private fun Container.LektionShowDiv(value: String, size: Int): Tag {
        return div(value).apply {
            marginTop = 40.px
            align = Align.CENTER
            alignContent = AlignContent.CENTER
            width = size.px
            height = size.px
            span {
                fontFamily = "Arial"
                fontSize = 30.px
                fontWeight = FontWeight.BOLDER
                fontVariant = FontVariant.SMALLCAPS
                +io.kvision.i18n.tr("Lektion 1")
            }
        }
    }

    private fun Container.BegruessungsDiv(value: String, size: Int): Tag {
        return div(value).apply {
            marginTop = 40.px
            align = Align.CENTER
            width = 400.px
            height = 200.px
            span {
                fontFamily = "Arial"
                fontSize = 32.px
                fontStyle = FontStyle.OBLIQUE
                fontWeight = FontWeight.BOLDER
                fontVariant = FontVariant.SMALLCAPS
                +io.kvision.i18n.tr("Hello Alice")

            }
           /* div().bind(Model.user()) { user ->
                if (user.name != null) {
                    button("Logout: ${user.name}", "fas fa-sign-out-alt", style = ButtonStyle.WARNING).onClick {
                        document.location?.href = "/logout"
                    }
                }
            }*/

            div(rich = true) {
                +io.kvision.i18n.tr("<span style=\"font-family: Verdana; font-size: 14pt\">Du machst das großartig. Weiter so!</span>")
            }
        }
    }

    private fun Container.HomeButtonDiv(value: String, size: Int): Tag {
        return div(value).apply {
            marginTop = 40.px
            align = Align.CENTER
            width = size.px
            height = size.px
            image(io.kvision.require("img/IconHome2.png")) {
                maxWidth = 20.perc
            }
        }
    }

    private fun Container.AlarmButtonDiv(value: String, size: Int): Tag {
        return div(value).apply {
            marginTop = 40.px
            align = Align.CENTER
            width = size.px
            height = size.px
            image(io.kvision.require("img/IconBell2.png")) {
                maxWidth = 20.perc
            }
        }
    }

    private fun Container.ProfilBildDiv(value: String, size: Int): Tag {
        return div(value).apply {
            marginTop = 40.px
            align = Align.CENTER
            width = size.px
            height = size.px
            image(io.kvision.require("img/ProfilPic.png")) {
                maxWidth = 40.perc
            }
        }
    }


    private fun Container.addRespGridPanel() {
        addFlexPanel1()
        responsiveGridPanel {

            background = Background(Color.name(Col.DARKGRAY))

            options(1, 1) {
                PoolDiv("", 350)
            }
            options(2, 1) {
                Lesson1Div("", 0)

            }
            options(3, 1) {
                Lesson2Div("", 300)
            }

            options(2, 3) {
                weitereLektionenDiv("", 0)
            }
        }
    }


    private fun Container.customDiv(value: String, size: Int): Tag {
        return div(value).apply {
            paddingTop = ((size / 2) - 10).px
            align = Align.CENTER
            background = Background(Color.name(Col.GREEN))
            width = size.px
            height = size.px
        }
    }


    private fun Container.Lesson1Div(value: String, size: Int): Tag {
        return div(value).apply {
            align = Align.CENTER
            background = Background(Color.name(Col.LIGHTGRAY))
            marginTop = 150.px
            width = 800.px
            height = 500.px
            fontSize = 15.px
            fontFamily = "DejaVu Sans"

            val wordTrinken = observableListOf(
                I18n.tr("trinken")
            )

            val wordToDrink = observableListOf(
                I18n.tr("to drink")
            )


            hPanel(justify = JustifyContent.CENTER, alignItems = AlignItems.FLEXSTART, useWrappers = true, spacing = 50) {
                vPanel(spacing = 10) {
                    marginTop = 30.px
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
                    marginTop = 30.px
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


            hPanel(justify = JustifyContent.CENTER, alignItems = AlignItems.FLEXSTART, useWrappers = true, spacing = 50) {
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


            hPanel(justify = JustifyContent.CENTER, alignItems = AlignItems.FLEXSTART, useWrappers = true, spacing = 50) {
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
                button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.SECONDARY).onClick{
                    Alert.show(
                        I18n.tr("Aufgabenstellung: Lektion 1, Lesson3"),
                        "Fügen Sie die richtigen Wortpaare zusammen.",
                        animation = false
                    )
                }
            }
        }
    }
}

private fun Container.Lesson2Div(value: String, size: Int): Tag {
    return div(value).apply {
    }
}

private fun Container.weitereLektionenDiv(value: String, size: Int): Tag {
    return div(value).apply {
        marginTop = 7.px
        align = Align.CENTER
        width = 940.px
        height = 100.px
        toolbar {
            buttonGroup {
                button(""){
                    marginLeft = 4.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button("3", disabled = true){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
                button(""){
                    marginLeft = 20.perc
                    background = Background(Color.name(Col.ROSYBROWN))
                }
            }
        }
    }
}

private fun Container.PoolDiv(value: String, size: Int): Tag {
    return div(value).apply {

        align = Align.CENTER
        background = Background(Color.name(Col.LIGHTGREEN))
        width = 300.px
        height = 600.px
        marginTop = 60.px
        marginLeft = 0.px

        image(io.kvision.require("img/logoPoodle.png")) {
            maxWidth = 80.perc
        }

        button(I18n.tr("Übersicht"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 60.px
            fontSize = 15.px
            fontFamily = "Arial"
        }

        button(I18n.tr("Lektionen"), style = ButtonStyle.SECONDARY) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
        }

        button(I18n.tr("Einstellungen"), style = ButtonStyle.LIGHT) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
        }

        button(I18n.tr("Ausloggen"), style = ButtonStyle.LIGHT) {
            width = 200.px
            marginTop = 60.px
            fontSize = 15.px
            fontFamily = "Arial"
        }
    }

}
