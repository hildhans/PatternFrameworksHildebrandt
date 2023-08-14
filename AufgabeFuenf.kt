package com.p_f

import io.kvision.core.Container
import io.kvision.core.CssSize
import io.kvision.core.UNIT
import io.kvision.form.text.TextInput
import io.kvision.utils.px
import io.kvision.core.onClick
import io.kvision.form.form
import io.kvision.form.text.textAreaInput
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.modal.Alert
import io.kvision.panel.gridPanel
import io.kvision.panel.vPanel
import io.kvision.panel.vPanel

data class Flashcard(val question: String, val answer: String)

class AufgabeFuenf : DesktopWindow("Aufgabe 5 Lesson 1", "", 1000, 800) {

    private val flashcards = mutableListOf(
        Flashcard("er", "he"),
        Flashcard("sie", "they"),
        Flashcard("wir", "we"),
        Flashcard("ich", "I"),
        Flashcard("es", "it"),
        Flashcard("du", "you"),
        Flashcard("Sie(höflich)", "you"),
    )

    private var currentFlashcardIndex = 0


    init {


        button(I18n.tr("Nächste Flashcard"), style = ButtonStyle.INFO) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            onClick {
                currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.size
                flashcards[currentFlashcardIndex].question
            }
        }

        div{
        button(I18n.tr("auf Deutsch: "), style = ButtonStyle.SECONDARY) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            onClick {
                Alert.show(
                    I18n.tr("deutsche Übersetzung: ")
                            + flashcards[currentFlashcardIndex].question
                )
            }
        }
    }
        div{
            button(I18n.tr("auf Englisch: "), style = ButtonStyle.OUTLINESECONDARY)
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            onClick {
                Alert.show(
                    I18n.tr("englische Übersetzung: ")
                            + flashcards[currentFlashcardIndex].answer
                )

            }
        }

        }



          companion object {
                fun run(container: Container) {
                    container.add(AufgabeFuenf())
                }
            }
            }





