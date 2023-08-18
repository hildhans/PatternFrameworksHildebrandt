package com.p_f

import io.kvision.core.*
import io.kvision.form.text.TextInput
import io.kvision.utils.px

import io.kvision.form.check.checkBox
import io.kvision.form.text.textInput
import io.kvision.html.*
import io.kvision.i18n.I18n
import io.kvision.i18n.I18n.tr
import io.kvision.i18n.gettext
import io.kvision.modal.Alert
import io.kvision.modal.Confirm
import io.kvision.modal.Modal
import io.kvision.offcanvas.OffPlacement
import io.kvision.offcanvas.offcanvas
import io.kvision.panel.SimplePanel
import io.kvision.panel.vPanel
import io.kvision.require
import io.kvision.toast.ToastContainer
import io.kvision.toast.ToastContainerPosition
import io.kvision.utils.px
import io.kvision.window.Window
import kotlin.random.Random


data class Flashcard(val question: String, val answer: String)

class AufgabeZehn : DesktopWindow("Aufgabe 10 Lesson 1", "", 1000, 800) {

 val flashcards = mutableListOf(
        Flashcard("er", "he"),
        Flashcard("sie", "they"),
        Flashcard("wir", "we"),
        Flashcard("ich", "I"),
        Flashcard("es", "it"),
        Flashcard("du", "you"),
        Flashcard("Sie(höflich)", "you"),
    )

    var currentFlashcardIndex = 0



    init {
        this.marginTop = 10.px
        this.minHeight = 400.px



        val modal = Modal(I18n.tr("Flashcard"))

        modal.add(Image(require("img/dog.jpg")))



        modal.addButton(Button(
            (I18n.tr("Wordpaar: ")), style = ButtonStyle.SECONDARY) {
            width = 250.px
            marginTop = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            onClick {
                Alert.show(
                    flashcards[currentFlashcardIndex].question +  (" : ")
                            + flashcards[currentFlashcardIndex].answer
                )

            }
        }
        )

        /*

                modal.addButton(Button(I18n.tr("Close")) {
                    width = 250.px
                    marginTop = 20.px
                    marginLeft = 20.px
                    marginRight = 20.px
                    fontSize = 15.px
                    fontFamily = "Arial"
                    marginBottom = 50.px
                    onClick {
                        modal.hide()
                    }
                })
        */

        button(I18n.tr("Nächste Flashcard"), style = ButtonStyle.INFO) {
            width = 250.px
            marginTop = 20.px
            marginLeft = 20.px
            marginRight = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            onClick {
                currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.size
                flashcards[currentFlashcardIndex].question
                modal.show()
            }
        }
        button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.DANGER).onClick {
            Alert.show("Wenn Sie den obrigen Button betätigen klicken Sie sich durch die Flashcards!")
        }

        }


    companion object {
        fun run(container: Container) {
            container.add(AufgabeZehn())
        }
    }
    }
