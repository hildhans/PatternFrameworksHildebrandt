package com.p_f

import io.kvision.core.*
import io.kvision.html.ButtonStyle
import io.kvision.html.Image
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.modal.Alert
import io.kvision.modal.Modal
import io.kvision.panel.gridPanel
import io.kvision.panel.vPanel
import io.kvision.utils.px



data class Flashcard(val deutsch: String, val englisch: String)

class AufgabeFuenf : DesktopWindow("Aufgabe 5 Lesson 1", "", 1000, 800) {

    val flashcards = mutableListOf(
        Flashcard("er", "he"),
        Flashcard("sie", "she"),
        Flashcard("es", "it"),
        Flashcard("du", "you"),
        Flashcard("wir", "we"),
        Flashcard("ich", "I"),
        Flashcard("Sie(höflich)", "you"),
        Flashcard("sie", "they"),
        Flashcard("ihr", "you")
    )


    //  Flashcard("du", "you", require("img/dog.jpg")),
    //var currentFlashcardIndex = 1

    val imageView_er = Image("img/er.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_sie = Image("img/sie.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_it = Image("img/it.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_du = Image("img/du.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_we = Image("img/wir.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_i = Image("img/ich.jpg").apply {
        height = 250.px
        margin = 10.px
    }


    val imageView_sie3 = Image("img/Sie_2.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_sie2 = Image("img/sie_3.jpg").apply {
        height = 250.px
        margin = 10.px
    }

    val imageView_ihr = Image("img/ihr.jpg").apply {
        height = 250.px
        margin = 10.px
    }


    /*
    val imageView = Image("img/cat.jpg").apply{
        width = 200.px
        height = 200.px
        margin = 10.px
    }
    */
    init {
        this.marginTop = 20.px
        this.minHeight = 600.px
        background = Background(Color.name(Col.LIGHTGRAY))
        vPanel(justify = JustifyContent.SPACEAROUND, alignItems = AlignItems.CENTER, spacing = 50) {
            button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.LIGHT) {
                alignContent = AlignContent.CENTER
                margin = 2.px
                width = 200.px
                height = 50.px
                marginTop = 20.px
                fontSize = 15.px
                fontFamily = "Arial"
                background = Background(Color.name(Col.ROSYBROWN))
                onClick {
                    Alert.show(
                        I18n.tr("Aufgabenstellung: Lektion 1, Lesson 5"),
                        "Klicken Sie auf die Flashcards und merken Sie sich die jeweils englische Bezeichnung der Personalpronomen!",
                        animation = false
                    )
                }
            }
        gridPanel(columnGap = 5, rowGap = 5, justifyItems = JustifyItems.CENTER) {
            options(1, 1) {
                add(imageView_er)
            }

            options(2, 1) {
                add(imageView_sie)
            }
            options(1, 2) {
                add(imageView_it)
            }

            options(2, 2) {
                add(imageView_du)
            }

            options(1, 3) {
                add(imageView_we)
            }

            options(2, 3) {
                add(imageView_i)
            }
            options(1, 4) {
                add(imageView_sie3)
            }
            options(2, 4) {
                add(imageView_sie2)
            }
            options(1, 5) {
                add(imageView_ihr)
            }

        }

        }



        val modal = Modal(I18n.tr("Flashcard"))


        modal.add(div {
            imageView_er.onClick {
                Alert.show(
                    I18n.tr( flashcards[0].deutsch),
                            flashcards[0].englisch + (" (") + 1 + (" von  9)")
                )

                /* currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.size
              flashcards[currentFlashcardIndex].deutsch*/
            }
        })


        modal.add(div {
            imageView_sie.onClick {
                Alert.show(
                    I18n.tr(flashcards[1].deutsch),
                        flashcards[1].englisch + (" (") + 2 + (" von  9)")
                )
            }
        })

        modal.add(div {
            imageView_it.onClick {
                Alert.show(
                    I18n.tr(flashcards[2].deutsch),
                            flashcards[2].englisch + (" (") + 3 + (" von  9)")
                )
            }
        })

        modal.add(div {
            imageView_du.onClick {
                Alert.show(
                    I18n.tr(flashcards[3].deutsch),
                            flashcards[3].englisch + (" (") + 4 + (" von  9)")
                )
            }
        })

        modal.add(div {
            imageView_we.onClick {
                Alert.show(
                    I18n.tr(flashcards[4].deutsch),
                            flashcards[4].englisch + (" (") + 5 + (" von  9)")
                )
            }
        })

        modal.add(div {
            imageView_i.onClick {
                Alert.show(
                    I18n.tr(flashcards[5].deutsch),
                    flashcards[5].englisch + (" (") + 6 + (" von  9")
                )
            }
        })

        modal.add(div {
            imageView_sie3.onClick {
                Alert.show(
                    I18n.tr(flashcards[6].deutsch),
                    flashcards[6].englisch + (" (") + 7 + (" von  9)")
                )
            }
        })


        modal.add(div {
            imageView_sie2.onClick {
                Alert.show(
                    I18n.tr(flashcards[7].deutsch),
                            flashcards[7].englisch + (" (") + 8 + (" von  9)")
                )
            }
        })
        modal.add(div {
            imageView_ihr.onClick {
                Alert.show(
                    I18n.tr(flashcards[8].deutsch),
                    flashcards[8].englisch + (" (") + 9 + (" von  9)")
                )
            }
        })
    }


    companion object {
        fun run(container: Container) {
            container.add(AufgabeFuenf())
        }
    }
}

