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
        Flashcard("We like to dance", "Yes, we like it very much"),
        Flashcard("Do you have a dog", "Yes, his name ist Benno"),
        Flashcard("I traveled to Budapest, when", "I was a studend"),
        Flashcard("When I am at home", "I usually relax."),
    )

    private var currentFlashcardIndex = 0



        init {
            button("Next Flashcard").onClick {
                currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.size
                flashcards[currentFlashcardIndex].question
            }
            div {
                button("Frage: ").onClick {
                    +flashcards[currentFlashcardIndex].question
                }
            }
            div {
                button("Antwort: ").onClick {
                    +flashcards[currentFlashcardIndex].answer
                }

            }

            button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.SECONDARY).onClick {
                Alert.show(
                    I18n.tr("Aufgabenstellung: Lektion 1, Lesson 5"),
                    "Merke dir, welche Fagen zu welchen Antworten gehören.",
                    animation = false )
            }



            }


companion object {
    fun run(container: Container) {
        container.add(AufgabeFuenf())
    }
}
}




