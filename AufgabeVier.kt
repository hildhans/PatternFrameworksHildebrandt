package com.p_f


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

    init {
        this.marginTop = 10.px
        this.minHeight = 400.px

        vPanel(spacing = 30) {

            val store = object : ObservableValue<String>("") {
                fun update(v: String) {
                    if (value != v) {
                        value = v
                    }
                }

                fun addDot() {
                    value += "."
                }
            }
            div {
                text(label = I18n.tr("Input")).bind(store) {
                    placeholder = I18n.tr("Add some input")
                    value = it
                }.subscribe { store.update(it ?: "") }
                text(label = I18n.tr("Value")).bind(store) {
                    readonly = true
                    value = it
                }
                div(className = "form-group mb-3") {
                    button(I18n.tr("Add a dot")).onClick { store.addDot() }
                }
            }

            val panel = vPanel(spacing = 5, useWrappers = true)

            data class DataModel(val checked: Boolean, val text: String)
            data class DataState(val list: List<DataModel>, var searchFilter: String?)

            val dataState = ObservableValue(
                DataState(
                    listOf(
                        DataModel(false, I18n.tr("January")),
                        DataModel(false, I18n.tr("February")),
                        DataModel(false, I18n.tr("March")),
                        DataModel(false, I18n.tr("April")),
                        DataModel(false, I18n.tr("May")),
                        DataModel(false, I18n.tr("June")),
                        DataModel(false, I18n.tr("July")),
                        DataModel(false, I18n.tr("August")),
                        DataModel(false, I18n.tr("September")),
                        DataModel(false, I18n.tr("October")),
                        DataModel(false, I18n.tr("November"))
                    ), null
                )
            )

            val dataContainer = HPanel(spacing = 10, wrap = FlexWrap.WRAP).bind(dataState) { state ->
                state.list.filter { model ->
                    state.searchFilter?.let {
                        I18n.trans(model.text).contains(it, ignoreCase = true)
                    } ?: true
                }.forEach { model ->
                    checkBox(
                        value = model.checked,
                        label = model.text
                    ) {
                        flabel.fontWeight = if (model.checked) FontWeight.BOLD else null
                        style = CheckStyle.PRIMARY
                        onClick {
                            val idx = state.list.indexOf(model)
                            dataState.value = dataState.value.copy(
                                list = state.list.mapIndexed { index, dataModel -> if (index == idx) dataModel.copy(checked = this.value) else dataModel }
                            )
                        }
                    }
                }
            }
            panel.add(dataContainer)

            panel.add(HPanel(spacing = 10, wrap = FlexWrap.WRAP) {
                textInput(type = InputType.SEARCH) {
                    width = 200.px
                    placeholder = I18n.tr("Search ...")
                    onEvent {
                        input = {
                            dataState.value = dataState.value.copy(searchFilter = self.value)
                        }
                    }
                }
                button(I18n.tr("Add december"), style = ButtonStyle.SUCCESS).onClick {
                    dataState.value = dataState.value.copy(list = dataState.value.list + DataModel(true, I18n.tr("December")))
                }
                button(I18n.tr("Check all"), style = ButtonStyle.INFO).onClick {
                    dataState.value = dataState.value.copy(list = dataState.value.list.map { it.copy(checked = true) })
                }
                button(I18n.tr("Uncheck all"), style = ButtonStyle.INFO).onClick {
                    dataState.value = dataState.value.copy(list = dataState.value.list.map { it.copy(checked = false) })
                }
                button(I18n.tr("Reverse list"), style = ButtonStyle.DANGER).onClick {
                    dataState.value = dataState.value.copy(list = dataState.value.list.reversed())
                }
                button(I18n.tr("Remove checked"), style = ButtonStyle.DANGER).onClick {
                    dataState.value = dataState.value.copy(list = dataState.value.list.filter { !it.checked })
                }
            })
        }
    }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeVier())
        }
    }
}
