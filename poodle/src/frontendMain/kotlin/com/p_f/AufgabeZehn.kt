package com.p_f


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
import io.kvision.state.ObservableList

import io.kvision.state.bindEach
import io.kvision.state.observableListOf
import kotlin.collections.List

//class AufgabeZehn(className: String? = null,/* init: Card.() -> Unit? = null*/) : DesktopWindow()
class AufgabeZehn: DesktopWindow("Aufgabe 10 Lesson 1: Translate", "", 1000, 800) {

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
    fun newvocab() {
        // Erstelle eine Liste mit den drei Wörtern
        val words = listOf("Hallo", "Auto", "Auf Wiedersehen", "Flasche", "Tasche")

        // Wiederhole so lange, bis der Zähler die Größe der Liste erreicht hat
        if (counter < words.size) {
            // Gebe das aktuelle Wort in einem Alert aus
            Alert.show(
                I18n.tr("Translate the following:"),
                I18n.tr(words[counter]),
                animation = false )

            // Erhöhe den Zähler um eins
            counter++
        }
       else {
            // Setze den Zähler zurück
            counter = 0
        }
    }

    fun getRandomLetter(): Char {
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
    //var vocabletter = '?'

    /*eleganter als hardcode, eine Fkt, die den String fetcht, der gerade in Translate angezeigt wird und mir daraus eine Liste erstellt
    dann eine Funktion,die die aufsplittet und mir alle Buchstaben einzeln ausgibt
    --> so
    */
    val letters = getVocabLetter()
    /*fun getCarLetter(): Array<Char> {
        // Erstelle drei Variablen des Typs Char
        val letterC = 'c'
        val letterA = 'a'
        val letterR = 'r'

        // Gib die drei Variablen zurück
        return arrayOf(letterC, letterA, letterR)
    }*/

    fun getVocabLetter(): Array<Char> {
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
        minWidth = 500.px
        minHeight = 180.px
        padding = 3.px
        richText.height = 370.px
        add(richText)
        height = 457.px

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

            //tr(getVocabLetter().toString())
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
            list.add(tr(getRandomLetter().toString()))
            list.add(tr(letters[14].toString()))
        }
        fun updateListBottle() {
            // Aktualisiere den Inhalt der Liste mit den Buchstaben für bottle
            list.clear()
            list.add(tr(getRandomLetter().toString()))
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


        div(rich = true) { //Check Button
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Check"), style = ButtonStyle.SECONDARY).onClick {
                Alert.show(
                    I18n.tr("Check"),
                    I18n.tr("Good job!"),
                    animation = false )
                updateListCar()
                //getRandomLetter()
               // newletterlist()

            }
        }

        div(rich = true) { //Translation Button
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Translation"), style = ButtonStyle.SECONDARY).onClick {
               newvocab()
               /* Alert.show(
                    I18n.tr("Translate the following:"),
                    I18n.tr("Hallo"),
                    animation = false )*/
            }

        }
        // hat noch keine Funktion, Idee, dass hier je nach Vokabel die richtige Fkt ausgeführt wird, um die Buchstaben zu setzen
        div(rich = true) { //Start Button
            marginTop = 60.px
            marginLeft = 370.px
            button(I18n.tr("Start"), style = ButtonStyle.SECONDARY).onClick {
                //setzt die richtigen Buchstaben in die Ausgangsliste

            }

        }





        val listBlue = observableListOf(
            tr("")
        )
        hPanel(justify = JustifyContent.CENTER, alignItems = AlignItems.FLEXSTART, useWrappers = true, spacing = 50) {
            hPanel(spacing = 10) { //grünes Panel Ausgangspanel
               // alignContent = AlignContent.CENTER
                width = 290.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.GREEN))
                setDropTargetData("text/xml") { data ->
                    if (data != null) {
                        listBlue.remove(data)
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
                width = 290.px
                height = 50.px
                padding = 10.px
                border = Border(2.px, BorderStyle.SOLID, Color.name(Col.BLUE))
                setDropTargetData("text/plain") { data ->
                    if (data != null) {
                        list.remove(data)
                        listBlue.add(data)
                    }
                }
            }.bindEach(listBlue) {
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

    /*
    open class Card(
        className: String? = null,
        init: (Card.() -> Unit?)?
    ) : SimplePanel()
*/
   /* fun onclickvocab() {
        //var index: Int = 1
        var arrayTrans = ArrayList<String>()
        arrayTrans[0] = "Auto"
        arrayTrans[1] = "Auf Wiedersehen"
        arrayTrans[2] = "Flasche"

        Alert.show(
            I18n.tr("Translate the following:"),
            I18n.tr(arrayTrans[0]),
            // I18n.tr(arrayTrans[index]),
            animation = false )
        //index = index +1

    }*/

    companion object {
        fun run(container: Container) {
            container.add(AufgabeZehn())
        }
    }


}

