package com.p_f.Lessons


import com.p_f.DesktopWindow
import io.kvision.core.*
import io.kvision.form.text.TextInput
import io.kvision.utils.px

//drag drop
import io.kvision.core.AlignItems
import io.kvision.core.Border
import io.kvision.core.BorderStyle
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.JustifyContent
import io.kvision.html.Align
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.i18n.I18n.tr
import io.kvision.modal.Alert
import io.kvision.panel.hPanel

import io.kvision.state.bindEach
import io.kvision.state.observableListOf

class AufgabeZehn: DesktopWindow("Aufgabe 10 Lesson 1: Translate", "", 1000, 800) {
    init {
        this.marginTop = 10.px
        this.minHeight = 400.px
        background = Background(Color.name(Col.IVORY))
    }
    override var height: CssSize?
        get() = super.height
        set(value) {
            super.height = value
            if (value?.second == UNIT.px) {
                richText.height = (value.first.toInt() - 93).px
            }
        }

    val richText = TextInput()
    // Erstelle einen Zähler für newvocab fun
    var counter = 0
    // Erstelle eine Liste mit den drei Wörtern
    val words = listOf("Hallo", "Auto", "Auf Wiedersehen", "Flasche", "Tasche")
    fun newVocab(): Int {
        // Wiederhole so lange, bis der Zähler die Größe der Liste erreicht hat
        if (counter < words.size-1 ) {
            // Gebe das aktuelle Wort in einem Alert aus
            counter++
            /*Alert.show(
                I18n.tr("Translate the following:"),
                I18n.tr(words[counter]),
                animation = false )*/
        }
        else {
            // Setze den Zähler zurück
            counter = 0
        }
        return counter

    }
    fun showVocab() {
        // Gebe das aktuelle Wort in einem Alert aus
        Alert.show(
            I18n.tr("Translate the following:"),
            I18n.tr(words[counter]),
            animation = false
        )
    }

    private fun getRandomLetter(): Char {
// Erstelle eine Liste mit allen Buchstaben des Alphabets
        var letters = listOf(
            'a',
            'b',
            'c',
            'd',
            'e',
            'f',
            'g',
            'h',
            'i',
            'j',
            'k',
            'l',
            'm',
            'n',
            'o',
            'p',
            'q',
            'r',
            's',
            't',
            'u',
            'v',
            'w',
            'x',
            'y',
            'z'
        )

// Wähle einen zufälligen Buchstaben aus der Liste
        var randomLetter = letters.random()

// Gib den Buchstaben zurück
        return randomLetter
    }
    val letters = getVocabLetter()
    private fun getVocabLetter(): Array<Char> {
        // Erstelle ein Array mit 26 Elementen des Typs Char
        val letters = Array(26) { 'a' }

        // Setze die Buchstaben des Alphabets in das Array
        for (i in 0 until 26) {
            letters[i] = ('a' + i).toChar()
        }

        // Gib das Array zurück
        return letters
    }

    init {
        //minWidth = 500.px
        //minHeight = 180.px
        padding = 3.px
        //richText.height = 370.px
        //add(richText)
        //height = 457.px

        this.marginTop = 10.px
        this.minHeight = 400.px

        //Liste links startbox Buchstaben
        var list = observableListOf(
            //8 zufällige Buchstaben
            tr(getRandomLetter().toString()) ,
            tr(getRandomLetter().toString()),
            tr(getRandomLetter().toString()) ,
            tr(letters[0].toString()),
            tr(letters[17].toString()),
            tr(getRandomLetter().toString()),
            tr(getRandomLetter().toString()) ,
            tr(getRandomLetter().toString()),
            tr(getRandomLetter().toString()) ,
            tr(letters[2].toString()),
            tr(getRandomLetter().toString()),
            tr(getVocabLetter().toString())
        )

        fun updateListHello() {
            // Aktualisiere den Inhalt der Liste mit den Buchstaben für hello
            list.clear()
            list.add(tr(letters[14].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[4].toString()))
            list.add(tr(letters[7].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[11].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[11].toString()))
        }

        fun updateListGoodbye() {
            // Aktualisiere den Inhalt der Liste mit den Buchstaben für goodbye
            list.clear()
            list.add(tr(letters[4].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[1].toString()))
            list.add(tr(letters[3].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[24].toString()))
            list.add(tr(letters[14].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[6].toString()))
            // list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[14].toString()))
        }

        fun updateListBottle() {
            // Aktualisiere den Inhalt der Liste mit den Buchstaben für bottle
            list.clear()
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[14].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[19].toString()))
            list.add(tr(letters[4].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[19].toString()))
            list.add(tr(letters[1].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[11].toString()))
        }

        fun updateListCar() {
            // Aktualisiere den Inhalt der Liste mit den Buchstaben für car
            list.clear()
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[17].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[2].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[0].toString()))
        }
        fun updateListBag() {
            // Aktualisiere den Inhalt der Liste mit den Buchstaben für bag
            list.clear()
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[1].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[6].toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[0].toString()))
        }

        div(rich = true) {
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Task"), style = ButtonStyle.SECONDARY).onClick {
                Alert.show(
                    I18n.tr("Task: Lesson 1, Exercise 10"),
                    I18n.tr("Translate by ordering the letters"),
                    animation = false )
            }
        }

        var listTarget = observableListOf(
            tr("")
        )
        // updatet target Box Zielbox Zielpanel
        fun clearListTarget() {
            //Leere den Inhalt der Liste mit den Buchstaben für bag
            listTarget.clear()

        }

        fun checkTransl(): Boolean {
            //var stringTarget = listTarget.joinToString("")
            var stringTarget = listTarget.joinToString ("")
            //return stringTarget
            // prüfen hello (5)
            if (stringTarget == "###KvI18nS###h###KvI18nS###e###KvI18nS###l###KvI18nS###l###KvI18nS###o" && counter == 0) {
                // Gib true zurück
                return true

                // println(stringTarget)
            }
            // prüfen car (3)
            if (stringTarget == "###KvI18nS###c###KvI18nS###a###KvI18nS###r"  && counter == 1) {
                // Gib true zurück
                return true
                // println(stringTarget)
            }
            //prüfen goodbye (7)
            if (stringTarget == "###KvI18nS###g###KvI18nS###o###KvI18nS###o###KvI18nS###d###KvI18nS###b###KvI18nS###y###KvI18nS###e"  && counter == 2) {
                // Gib true zurück
                return true
                // println(stringTarget)
            }
            // prüfen bottle (6)
            if (stringTarget == "###KvI18nS###b###KvI18nS###o###KvI18nS###t###KvI18nS###t###KvI18nS###l###KvI18nS###e"  && counter == 3) {
                // Gib true zurück
                return true
                // println(stringTarget)
            }
            // prüfen bag (3)
            if (stringTarget == "###KvI18nS###b###KvI18nS###a###KvI18nS###g"  && counter == 4) {
                // Gib true zurück
                return true
                // println(stringTarget)
            }

            else {
                // Gib false zurück
                return false
                // println(stringTarget)
            }
            // return stringTarget*/
        }

        div(rich = true) { //Check Button
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Check"), style = ButtonStyle.SECONDARY).onClick {
                checkTransl()
                if (checkTransl()) {
                    Alert.show(
                        I18n.tr("Check"),
                        I18n.tr("That's right! Good job!"),
                        // I18n.tr(checkCar()),
                        animation = false
                    )
                    // clearListTarget()
                }
                else {
                    Alert.show(
                        I18n.tr("Check"),
                        I18n.tr("Not yet, try again!"),
                        //I18n.tr(stringTarget),
                        animation = false
                    )
                }

            }
        }

        div(rich = true) { //Translation Button
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Translation"), style = ButtonStyle.OUTLINEDARK) {
                background = Background(Color.name(Col.MISTYROSE))

                onClick {

                    if (checkTransl()) { // nur wenn richtig beantwortet und wenn die Liste leer ist
                        //die leere Liste dient als Kontrolle, ob der User schon geprüft hat, dass richtig geantwortet wurde
                        clearListTarget()
                        newVocab() //aktualisiert die angezeigte Vokabel, und erhöht counter
                        // aktualisiert die Liste mit Buchstaben je nach Vokabel
                        if (counter == 0) updateListHello()
                        if (counter == 1) updateListCar()
                        if (counter == 2) updateListGoodbye()
                        if (counter == 3) updateListBottle()
                        if (counter == 4) updateListBag()
                    }
                    /*if (counter==0) {
                    clearListTarget()
                    newVocab()
                    updateListHello()
                }*/
                    if (!checkTransl() && counter != 0) {
                        //newVocab()
                        showVocab()
                    }
                    //Startposition checkTransl falsch und string = ""
                    if (!checkTransl() && !listTarget.isEmpty() && counter != 0) {
                        //clearListTarget()
                        showVocab()

                    }
                    if (!checkTransl() && counter == 0) {
                        //newVocab()
                        clearListTarget()
                        showVocab()
                        updateListHello()
                    }
                }
            }

        }

        hPanel(justify = JustifyContent.CENTER, alignItems = AlignItems.FLEXSTART, useWrappers = true, spacing = 50) {
            marginTop = 60.px
            marginLeft = 60.px
            hPanel(spacing = 10) { //grünes Panel Ausgangspanel
                // alignContent = AlignContent.CENTER
                width = 325.px
                height = 60.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/xml") { data ->
                    if (data != null) {
                        listTarget.remove(data)
                        list.add(data)

                    }
                }
            }.bindEach(list) {
                div(it, align = Align.CENTER) {
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/plain", it)
                }
            }

            hPanel(spacing = 10) {//Zielpanel
                width = 325.px
                height = 60.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.ROSYBROWN))
                setDropTargetData("text/plain") { data ->
                    if (data != null) {
                        list.remove(data)
                        listTarget.add(data)
                    }
                }
            }.bindEach(listTarget) {
                div(it, align = Align.CENTER) {
                    padding = 3.px
                    border = Border(1.px, BorderStyle.DASHED)
                    setDragDropData("text/xml", it)
                }
            }

            fun focus() {
                super.focus()
                richText.focus()
            }
        }
    }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeZehn())
        }
    }
}
