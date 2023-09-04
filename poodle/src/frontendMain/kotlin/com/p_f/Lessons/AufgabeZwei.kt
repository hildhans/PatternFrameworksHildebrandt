package com.p_f.Lessons


import com.p_f.DesktopWindow
import io.kvision.core.*
import io.kvision.form.text.textArea
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.panel.hPanel
import io.kvision.i18n.I18n.tr
import io.kvision.modal.Alert
import io.kvision.panel.flexPanel
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.state.bindEach
import io.kvision.state.observableListOf
import io.kvision.utils.px



class AufgabeZwei : DesktopWindow("Aufgabe 2 Lesson 1", "", 1000, 800) {

    init {
        addHPanel_1()
        div{
            marginLeft = 400.px
            marginBottom = 100.px
            marginTop = 100.px
            button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.OUTLINEDARK) {
                background = Background(Color.name(Col.MISTYROSE))
                alignContent = AlignContent.CENTER
                margin = 2.px
                width = 200.px
                height = 50.px
                marginTop = 20.px
                fontSize = 15.px
                fontFamily = "Arial"
                //background = Background(Color.name(Col.ROSYBROWN))
                onClick {
                    Alert.show(
                        I18n.tr("Aufgabenstellung: Lektion 2, Lesson 1"),
                        "Bitte klicken Sie auf die Bilder, um zu sehen, welche Verben auf Englisch übersetzt werden sollen!",
                        animation = false
                    )
                }
            }
        }
    }

    fun Container.addHPanel_1(){
        hPanel {
            Bild1("", 600)
            Bild2("", 600)
            Bild3("", 600)
        }
    }

    fun Container.Bild1(value: String, size: Int): Tag {
        return div(value).apply {
            //paddingTop = ((size / 2) - 10).px
            width = size.px
            height = size.px
            width = size.px
            background = Background(Color.name(Col.IVORY))

            flexPanel(FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.FLEXSTART, AlignItems.CENTER, spacing = 5){

                val textausgabeSpan = span("").apply {
                    align = Align.CENTER
                    fontSize = 20.px
                    fontFamily = "Arial"
                    marginTop = 20.px
                    color = Color.hex(0x000000)
                }

                fun Container.sprachewiedergeben(textausgabeSpan: Span): Tag {
                    return div {
                        align = Align.LEFT
                        width = 700.px
                        height = 300.px
                        marginTop = 0.px
                        marginLeft = 50.px

                        image("img/schlafen.jpg") {
                            height = 200.px
                            marginTop = 50.px
                            marginBottom = 20.px
                            fontSize = 15.px
                            fontFamily = "Arial"
                            enablePopover(
                                PopoverOptions(
                                    title = I18n.tr("Bild 1 von 3"),
                                    content = "Folgendes Wort wird gesucht: schlafen"
                                )
                            )
                        }
                    }
                }

                fun Container.texteingabe(textausgabeSpan: Span): Tag {
                    return div {
                        align = Align.CENTER
                        fontSize = 15.px
                        fontFamily = "Arial"
                        width = 200.px
                        height = 10.px
                        marginTop = 30.px
                        marginLeft = 50.px
                        val ausgabe = span("Lösung"){
                            marginLeft = 10.px
                        }
                        val eingabe= textArea(rows = 1) {
                            marginTop = 5.px
                            placeholder = "Hier das englische Verb eingeben..."
                            background = Background(Color.name(Col.WHITE))
                        }
                        button("Bestätigen", style = ButtonStyle.OUTLINEDARK) {
                            background = Background(Color.name(Col.MISTYROSE))
                            width = 200.px
                            height = 50.px
                            marginTop = 20.px
                            marginBottom = 50.px
                            fontSize = 15.px
                            fontFamily = "Arial"
                            align = Align.CENTER
                            ///background = Background(Color.name(Col.PEACHPUFF))
                            onClick {
                                val eingegebenerText=eingabe.value.toString()
                                if (eingegebenerText=="to sleep")
                                    ausgabe.content = "richtig!"
                                /*if (eingegebenerText=="sleep")
                                    ausgabe.content = "noch nicht ganz!"*/
                                else ausgabe.content = "falsch"
                            }
                        }
                    }
                }
                add(sprachewiedergeben(textausgabeSpan))
                add(texteingabe(textausgabeSpan))
            }
        }
    }

    fun Container.Bild2(value: String, size: Int): Tag {
        return div(value).apply {
            //paddingTop = ((size / 2) - 10).px
            width = size.px
            height = size.px
            width = size.px
            background = Background(Color.name(Col.MISTYROSE))

            flexPanel(FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.FLEXSTART, AlignItems.CENTER, spacing = 5){

                val textausgabeSpan = span("").apply {
                    align = Align.CENTER
                    fontSize = 20.px
                    fontFamily = "Arial"
                    marginTop = 20.px
                    color = Color.hex(0x000000)
                }

                fun Container.sprachewiedergeben(textausgabeSpan: Span): Tag {
                    return div {
                        align = Align.LEFT
                        width = 700.px
                        height = 300.px
                        marginTop = 0.px
                        marginLeft = 50.px

                        image("img/sehen.png") {
                            height = 200.px
                            marginTop = 50.px
                            marginBottom = 20.px
                            fontSize = 15.px
                            fontFamily = "Arial"
                            enablePopover(
                                PopoverOptions(
                                    title = I18n.tr("Bild 2 von 3"),
                                    content = "Folgendes Wort wird gesucht: sehen"
                                )
                            )
                        }
                    }
                }

                fun Container.texteingabe(textausgabeSpan: Span): Tag {
                    return div {
                        align = Align.CENTER
                        fontSize = 15.px
                        fontFamily = "Arial"
                        width = 200.px
                        height = 10.px
                        marginTop = 30.px
                        marginLeft = 50.px
                        val ausgabe = span("Lösung"){
                            marginLeft = 10.px
                        }
                        val eingabe= textArea(rows = 1) {
                            marginTop = 5.px
                            placeholder = "Hier das englische Verb eingeben..."
                            background = Background(Color.name(Col.WHITE))
                        }
                        button("Bestätigen", style = ButtonStyle.OUTLINEDARK) {
                            background = Background(Color.name(Col.MISTYROSE))
                            width = 200.px
                            height = 50.px
                            marginTop = 20.px
                            marginBottom = 50.px
                            fontSize = 15.px
                            fontFamily = "Arial"
                            align = Align.CENTER
                            //background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                val eingegebenerText=eingabe.value.toString()
                                if (eingegebenerText=="to see")
                                    ausgabe.content = "richtig!"
                                /*if (eingegebenerText=="see")
                                    ausgabe.content = "noch nicht ganz!"*/
                                else ausgabe.content = "falsch"
                            }
                        }
                    }
                }
                add(sprachewiedergeben(textausgabeSpan))
                add(texteingabe(textausgabeSpan))
            }
        }
    }

    fun Container.Bild3(value: String, size: Int): Tag {
        return div(value).apply {
            //paddingTop = ((size / 2) - 10).px
            width = size.px
            height = size.px
            width = size.px
            background = Background(Color.name(Col.IVORY))

            flexPanel(FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.FLEXSTART, AlignItems.CENTER, spacing = 5){

                val textausgabeSpan = span("").apply {
                    align = Align.CENTER
                    fontSize = 20.px
                    fontFamily = "Arial"
                    marginTop = 20.px
                    color = Color.hex(0x000000)
                }

                fun Container.sprachewiedergeben(textausgabeSpan: Span): Tag {
                    return div {
                        align = Align.LEFT
                        width = 700.px
                        height = 300.px
                        marginTop = 0.px
                        marginLeft = 50.px

                        image("img/hoeren.jpg") {
                            height = 200.px
                            marginTop = 50.px
                            marginBottom = 20.px
                            fontSize = 15.px
                            fontFamily = "Arial"
                            enablePopover(
                                PopoverOptions(
                                    title = I18n.tr("Bild 3 von 3"),
                                    content = "Folgendes Wort wird gesucht: hören"
                                )
                            )
                        }
                    }
                }

                fun Container.texteingabe(textausgabeSpan: Span): Tag {
                    return div {
                        align = Align.CENTER
                        fontSize = 15.px
                        fontFamily = "Arial"
                        width = 200.px
                        height = 10.px
                        marginTop = 30.px
                        marginLeft = 50.px
                        val ausgabe = span("Lösung"){
                            marginLeft = 10.px
                        }
                        val eingabe= textArea(rows = 1) {
                            marginTop = 5.px
                            placeholder = "Hier das englische Verb eingeben..."
                            background = Background(Color.name(Col.WHITE))
                        }
                        button("Bestätigen", style = ButtonStyle.OUTLINEDARK) {
                            background = Background(Color.name(Col.MISTYROSE))
                            width = 200.px
                            height = 50.px
                            marginTop = 20.px
                            marginBottom = 50.px
                            fontSize = 15.px
                            fontFamily = "Arial"
                            align = Align.CENTER
                            //background = Background(Color.name(Col.PEACHPUFF))
                            onClick {
                                val eingegebenerText=eingabe.value.toString()
                                if (eingegebenerText=="to hear")
                                    ausgabe.content = "richtig!"
                                /*if (eingegebenerText=="hear")
                                    ausgabe.content = "noch nicht ganz!"*/
                                else ausgabe.content = "falsch"
                            }
                        }
                    }
                }
                add(sprachewiedergeben(textausgabeSpan))
                add(texteingabe(textausgabeSpan))
            }
        }
    }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeZwei())
        }
    }
}
