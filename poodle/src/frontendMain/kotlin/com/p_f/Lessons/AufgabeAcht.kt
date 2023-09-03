package com.p_f.Lessons


import com.p_f.DesktopWindow
import io.kvision.core.Container
import io.kvision.core.CssSize
import io.kvision.core.UNIT
import io.kvision.form.text.TextInput
import io.kvision.utils.px
import io.kvision.core.*
import io.kvision.form.text.textArea
import io.kvision.html.*
import korlibs.audio.format.AudioFormat
import java.io.*

class AufgabeAcht : DesktopWindow("Aufgabe 8 Lesson 1", "", 1000, 800) {
    object MP3 : AudioFormat("mp3")
    override var height: CssSize?
        get() = super.height
        set(value) {
            super.height = value
            if (value?.second == UNIT.px) {
                richText.height = (value.first.toInt() - 93).px
            }
        }

    val richText = TextInput()

    init {
        minWidth = 500.px
        minHeight = 180.px
        padding = 3.px
        richText.height = 370.px
        add(richText)
        height = 457.px
        val textausgabeSpan = span("").apply {
            align = Align.CENTER
            fontSize = 20.px
            fontFamily = "Arial"
            marginTop = 20.px
            color = Color.hex(0x000000)
        }

        add(Aufgabenstellung(""))
        add(sprachewiedergeben(textausgabeSpan))
        add(texteingabe(textausgabeSpan))
    }
    fun Container.sprachewiedergeben(textausgabeSpan: Span): Tag {
        return div {
            align = Align.LEFT
            background = Background(Color.name(Col.LIGHTGREEN))
            width = 1400.px
            height = 150.px
            marginTop = 0.px
            marginLeft = 250.px

            button("Sprachwiedergabe starten", style = ButtonStyle.LIGHT) {
                width = 250.px
                marginTop = 50.px
                fontSize = 15.px
                fontFamily = "Arial"
                align = Align.CENTER
                onClick {
                    text = "Erneut abspielen"
                }
            }
        }
    }

    fun Container.texteingabe(textausgabeSpan: Span): Tag {
        return div {
            align = Align.CENTER
            background = Background(Color.name(Col.LIGHTGRAY))
            fontSize = 35.px
            fontFamily = "Arial"
            width = 1400.px
            height = 50.px
            marginLeft = 250.px
            val ausgabe = span("Hier kommt die Auflösung")
            val eingabe= textArea(rows = 1) {
                placeholder = "Hier den Text eingeben..."
            }
            button("Eingabe bestätigen", style = ButtonStyle.LIGHT) {
                width = 250.px
                marginTop = 50.px
                fontSize = 15.px
                fontFamily = "Arial"
                align = Align.CENTER
                onClick {
                    val eingegebenerText=eingabe.value.toString()
                    if (eingegebenerText=="Hallo wie geht es dir?")
                        ausgabe.content = "richtig!"
                    else ausgabe.content = "Falsch, bitte versuch es noch einmal!"
                }
            }
        }
    }


    fun Container.Aufgabenstellung(value: String): Tag {
        return div(value).apply {
            align = Align.CENTER
            background = Background(Color.name(Col.LIGHTGRAY))
            fontSize = 35.px
            fontFamily = "Arial"
            width = 1400.px
            height = 50.px
            marginLeft = 250.px
            marginTop = 150.px
            span("Bitte höre dir den folgenden Text an und schreibe ihn dann ins Textfeld: ")
        }
    }
    fun play() {
        val file = File("resources.audio.sound-effect-hd.mp3")
        if (file.exists())
            file.toVfs().readAudioStream().playAndWait()
    }
    override fun focus() {
        super.focus()
        richText.focus()
    }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeAcht())
        }
    }
}
