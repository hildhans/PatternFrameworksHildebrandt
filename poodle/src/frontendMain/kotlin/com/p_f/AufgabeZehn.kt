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
            /*val alert = Alert(null, words[counter], "OK")
            alert.show()*/
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
    /*fun newletterlist(): ObservableList<Char> {

      val list = observableListOf('h', 's', 'e','l', 'd','l', 'e','o')
        return list
    }*/
//Vorbereitung 10 Buchstaben einzeln aus Liste in newletterlist()

    // Erstelle einen Zähler
    var counterletter = 0
    fun newletterlist(): MutableList<List<Char>> {
        // Erstelle eine Liste mit 10 Listen von Zeichen
       // var letterlist = observableListOf<List<Char>>()
        val letterlist = mutableListOf<List<Char>>()
        letterlist.clear()
        // Wiederhole so lange, bis der Zähler 10 erreicht hat
        //while (counterletter < 9) {
            if (true)
            {
                // Erstelle eine Liste mit 10 zufälligen Zeichen
                val sublist = observableListOf<Char>()

                for (i in 0..9) {
                    sublist.add(('a'..'z').random())
                }


            // Füge die Liste zur Liste hinzu
            letterlist.add(sublist)

            // Erhöhe den Zähler um eins
            counterletter++
        }
            else {
                // Setze den Zähler zurück
                counterletter = 0
            }

        // Konvertiere die `observableList` in eine Liste von Zeichen
        //val letters = letterlist.flatMap { it }
        var letters = letterlist.flatMap { it }

        //Test in 10 Liten mit einem Char aufspalten, Achtung Return Funktion zu any geändert wegen Test
            val result = mutableListOf<List<Char>>()
            for (i in 0 until letters.size) {
                result.add(listOf(letters[i]))
            }
            return result

       // return letters

        /*// Gib die Liste zurück
        return letters*/

        /*// Gib die Liste zurück
        return list*/
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
                newletterlist()

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

        var list = observableListOf(

            tr(newletterlist().toString()
            )
        )



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
                        //list.add(data)

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

   /* private fun <T> Array(size: Int): Array<T> {

        return  String
        //TODO("Provide the return value")
    }*/
    companion object {
        fun run(container: Container) {
            container.add(AufgabeZehn())
        }
    }

}

