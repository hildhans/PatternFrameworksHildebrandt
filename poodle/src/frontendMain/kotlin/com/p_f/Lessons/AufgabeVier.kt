package com.p_f.Lessons


import com.p_f.DesktopWindow
import io.kvision.core.*
import io.kvision.form.check.CheckStyle
import io.kvision.form.check.checkBox
import io.kvision.form.text.TextInput
import io.kvision.form.text.text
import io.kvision.form.text.textInput
import io.kvision.html.ButtonStyle
import io.kvision.html.InputType
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.panel.HPanel
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.px

class AufgabeVier : DesktopWindow("Aufgabe 4 Lesson 1", "", 1000, 800) {
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
    }

    override fun focus() {
        super.focus()
        richText.focus()
    }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeEins())
        }
    }
}