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
import org.w3c.dom.HTMLAudioElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import kotlinx.browser.document
import kotlinx.browser.window


class AufgabeAcht : DesktopWindow("Aufgabe 8", "", 1400, 1000) {

    init {
        minWidth = 500.px
        minHeight = 180.px
        padding = 3.px

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
            background = Background(Color.name(Col.MISTYROSE))
            width = 1000.px
            height = 150.px
            marginTop = 0.px
            marginLeft = 250.px
            button("Sprachwiedergabe starten", style = ButtonStyle.LIGHT) {
                width = 250.px
                marginTop = 50.px
                fontSize = 15.px
                fontFamily = "Arial"
                align = Align.CENTER
                val audioElement = document.createElement("audio") as HTMLAudioElement
                onClick {
//                    val file = files.files?.get(0)
//                    if (file != null) {
                    //val url = "C:\\Users\\hans_\\Downloads\\Neuer Ordner\\PatternFrameworksHildebrandt\\poodle\\src\\frontendMain\\resources\\audio\\sound-effect-hd.mp3"
                    text = "Erneut abspielen"
                    val url = "audio/Sprachbeispiel.mp3"
                    audioElement.src = url
                    audioElement.play()}
            }
        }
    }

    fun Container.texteingabe(textausgabeSpan: Span): Tag {
        return div {
            align = Align.CENTER
            background = Background(Color.name(Col.PEACHPUFF))
            fontSize = 35.px
            fontFamily = "Arial"
            width = 1000.px
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
            background = Background(Color.name(Col.PEACHPUFF))
            fontSize = 35.px
            fontFamily = "Arial"
            width = 1000.px
            height = 50.px
            marginLeft = 250.px
            marginTop = 150.px
            span("Bitte höre dir den folgenden Text an und schreibe ihn dann ins Textfeld: ")
        }
    }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeAcht())
        }
    }
}