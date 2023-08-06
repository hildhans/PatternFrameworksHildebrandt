package com.p_f

import io.kvision.core.Container
import io.kvision.core.FlexWrap
import io.kvision.core.FontWeight
import io.kvision.form.check.CheckStyle
import io.kvision.form.check.checkBox
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.i18n.I18n
import io.kvision.i18n.I18n.tr
import io.kvision.i18n.I18n.trans
import io.kvision.modal.Alert
import io.kvision.panel.HPanel
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.px


class AufgabeDrei : DesktopWindow("Aufgabe 3 Lesson 1", "", 1000, 800) {
    init {
        this.marginTop = 10.px
        this.minHeight = 400.px

            val panel = vPanel(spacing = 5, useWrappers = true)

            data class DataModel(val hallo: Boolean, val text: String)
        data class DataModel2(val tschuess: Boolean, val text: String)
            data class DataState(val list: List<DataModel>, var searchFilter: String?)
        data class DataState2(val list: List<DataModel2>, var searchFilter:String?)

            val dataState = ObservableValue(
                DataState(
                    listOf(
                        DataModel(false, tr("Hello"))
                    ), null,
                )
            )

        val dataState2 = ObservableValue(
            DataState2(
                listOf(
                    DataModel2(false, tr("Good bye"))
                ), null,
            )
        )


            val dataContainer = HPanel(spacing = 10, wrap = FlexWrap.WRAP).bind(dataState) { state ->
                state.list.filter { model ->
                    state.searchFilter?.let {
                        trans(model.text).contains(it, ignoreCase = true)
                    } ?: true
                }.forEach { model ->
                    checkBox(
                        value = model.hallo,
                        label = model.text
                    ) {
                        flabel.fontWeight = if (model.hallo) FontWeight.BOLD else null
                        style = CheckStyle.PRIMARY
                        onClick {
                            val idx = state.list.indexOf(model)
                            dataState.value = dataState.value.copy(
                                list = state.list.mapIndexed { index, dataModel -> if (index == idx) dataModel.copy(hallo = this.value) else dataModel }
                            )
                        }
                    }
                }
            }
            panel.add(dataContainer)


        val dataContainer2 = HPanel(spacing = 10, wrap = FlexWrap.WRAP).bind(dataState2) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.tschuess,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.tschuess) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState2.value = dataState2.value.copy(
                            list = state.list.mapIndexed { index, dataModel2 -> if (index == idx) dataModel2.copy(tschuess = this.value) else dataModel2}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer2)

                button(tr("Hallo"), style = ButtonStyle.DANGER).onClick {
                    dataState.value = dataState.value.copy(list = dataState.value.list.filter { !it.hallo })
                }

                button(tr("Tschüss"), style = ButtonStyle.DANGER).onClick {
                    dataState2.value = dataState2.value.copy(list = dataState2.value.list.filter { !it.tschuess})
                }



                 button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.SECONDARY).onClick {
                     Alert.show(
                        I18n.tr("Aufgabenstellung: Lektion 1, Lesson 10"),
                        "Fügen Sie die richtigen Wortpaare zusammen.",
                         animation = false )
                        }
            }
    companion object {
        fun run(container: Container) {
            container.add(AufgabeDrei())
        }
    }
}

