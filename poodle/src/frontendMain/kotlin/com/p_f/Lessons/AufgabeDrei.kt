package com.p_f.Lessons

import com.p_f.DesktopWindow
import io.kvision.core.FlexWrap
import io.kvision.core.FontWeight

import io.kvision.form.check.CheckStyle
import io.kvision.form.check.checkBox

import io.kvision.html.ButtonStyle

import io.kvision.html.button

import io.kvision.i18n.I18n.tr
import io.kvision.i18n.I18n.trans
import io.kvision.panel.HPanel

import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.px
import io.kvision.core.Container


class AufgabeDrei : DesktopWindow("Aufgabe 3 Lesson 1", "", 1000, 800) {
    init {
        this.marginTop = 10.px
        this.minHeight = 400.px


            val panel = vPanel(spacing = 5, useWrappers = true)

            data class DataModel(val checked: Boolean, val text: String)
            data class DataState(val list: List<DataModel>, var searchFilter: String?)

            val dataState = ObservableValue(
                DataState(
                    listOf(
                        DataModel(false, tr("January")),
                        DataModel(false, tr("February"))
                    ), null
                )
            )

            val dataContainer = HPanel(spacing = 10, wrap = FlexWrap.WRAP).bind(dataState) { state ->
                state.list.filter { model ->
                    state.searchFilter?.let {
                        trans(model.text).contains(it, ignoreCase = true)
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

            button(tr("Remove checked"), style = ButtonStyle.DANGER).onClick {
                dataState.value = dataState.value.copy(list = dataState.value.list.filter { !it.checked })
            }
        }

    companion object {
        fun run(container: Container) {
            container.add(AufgabeDrei())
        }
    }
}

