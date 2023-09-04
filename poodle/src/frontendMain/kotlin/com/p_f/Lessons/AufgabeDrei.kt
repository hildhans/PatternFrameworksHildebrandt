package com.p_f.Lessons

import com.p_f.DesktopWindow
import io.kvision.core.*
import io.kvision.form.check.CheckStyle
import io.kvision.form.check.checkBox
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.i18n.I18n
import io.kvision.i18n.I18n.tr
import io.kvision.i18n.I18n.trans
import io.kvision.modal.Alert
import io.kvision.panel.VPanel
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.px


class AufgabeDrei : DesktopWindow("Aufgabe 3 Lesson 1", "", 1000, 800) {
    init {
        this.marginTop = 10.px
        this.minHeight = 400.px
        background = Background(Color.name(Col.IVORY))

        val panel = hPanel(spacing = 10, useWrappers = true)



        data class DataModel1(val hallo: Boolean, val text: String)
        data class DataModel2(val tschuess: Boolean, val text: String)
        data class DataModel3(val gehen: Boolean, val text: String)
        data class DataModel4(val sitzen: Boolean, val text: String)
        data class DataModel5(val maedchen: Boolean, val text: String)
        data class DataModel6(val junge: Boolean, val text: String)
        data class DataModel7(val tisch: Boolean, val text: String)
        data class DataModel8(val stuhl: Boolean, val text: String)
        data class DataModel9(val gutenacht: Boolean, val text: String)
        data class DataModel10(val gutenmorgen: Boolean, val text: String)

        data class DataState1(val list: List<DataModel1>, var searchFilter: String?)
        data class DataState2(val list: List<DataModel2>, var searchFilter:String?)
        data class DataState3(val list: List<DataModel3>, var searchFilter:String?)
        data class DataState4(val list: List<DataModel4>, var searchFilter:String?)
        data class DataState5(val list: List<DataModel5>, var searchFilter:String?)
        data class DataState6(val list: List<DataModel6>, var searchFilter:String?)
        data class DataState7(val list: List<DataModel7>, var searchFilter:String?)
        data class DataState8(val list: List<DataModel8>, var searchFilter:String?)
        data class DataState9(val list: List<DataModel9>, var searchFilter:String?)
        data class DataState10(val list: List<DataModel10>, var searchFilter:String?)

        val dataState1 = ObservableValue(
            DataState1(
                listOf(
                    DataModel1(false, tr("Hello"))
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

        val dataState3 = ObservableValue(
            DataState3(
                listOf(
                    DataModel3(false, tr("to go"))
                ), null,
            )
        )

        val dataState4 = ObservableValue(
            DataState4(
                listOf(
                    DataModel4(false, tr("to sit"))
                ), null,
            )
        )

        val dataState5 = ObservableValue(
            DataState5(
                listOf(
                    DataModel5(false, tr("girl"))
                ), null,
            )
        )

        val dataState6 = ObservableValue(
            DataState6(
                listOf(
                    DataModel6(false, tr("boy"))
                ), null,
            )
        )

        val dataState7 = ObservableValue(
            DataState7(
                listOf(
                    DataModel7(false, tr("table"))
                ), null,
            )
        )

        val dataState8 = ObservableValue(
            DataState8(
                listOf(
                    DataModel8(false, tr("chair"))
                ), null,
            )
        )

        val dataState9 = ObservableValue(
            DataState9(
                listOf(
                    DataModel9(false, tr("Good night"))
                ), null,
            )
        )


        val dataState10 = ObservableValue(
            DataState10(
                listOf(
                    DataModel10(false, tr("Good morning"))
                ), null,
            )
        )



        val dataContainer1 = VPanel(spacing = 10).bind(dataState1) { state ->
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
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState1.value = dataState1.value.copy(
                            list = state.list.mapIndexed { index, dataModel -> if (index == idx) dataModel.copy(hallo = this.value) else dataModel }
                        )
                    }
                }
            }
        }
        panel.add(dataContainer1)


        val dataContainer2 = VPanel(spacing = 10).bind(dataState2) { state ->
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
                    marginTop = 50.px
                    marginBottom = 50.px
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

        val dataContainer3 = VPanel(spacing = 10).bind(dataState3) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.gehen,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.gehen) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState3.value = dataState3.value.copy(
                            list = state.list.mapIndexed { index, dataModel3 -> if (index == idx) dataModel3.copy(gehen = this.value) else dataModel3}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer3)


        val dataContainer4 = VPanel(spacing = 10).bind(dataState4) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.sitzen,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.sitzen) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState4.value = dataState4.value.copy(
                            list = state.list.mapIndexed { index, dataModel4 -> if (index == idx) dataModel4.copy(sitzen = this.value) else dataModel4}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer4)


        val dataContainer5 = VPanel(spacing = 10).bind(dataState5) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.maedchen,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.maedchen) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState5.value = dataState5.value.copy(
                            list = state.list.mapIndexed { index, dataModel5 -> if (index == idx) dataModel5.copy(maedchen = this.value) else dataModel5}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer5)


        val dataContainer6 = VPanel(spacing = 10).bind(dataState6) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.junge,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.junge) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState6.value = dataState6.value.copy(
                            list = state.list.mapIndexed { index, dataModel6 -> if (index == idx) dataModel6.copy(junge = this.value) else dataModel6}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer6)


        val dataContainer7 = VPanel(spacing = 10).bind(dataState7) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.tisch,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.tisch) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState7.value = dataState7.value.copy(
                            list = state.list.mapIndexed { index, dataModel7 -> if (index == idx) dataModel7.copy(tisch = this.value) else dataModel7}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer7)


        val dataContainer8 = VPanel(spacing = 10).bind(dataState8) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.stuhl,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.stuhl) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState8.value = dataState8.value.copy(
                            list = state.list.mapIndexed { index, dataModel8 -> if (index == idx) dataModel8.copy(stuhl = this.value) else dataModel8}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer8)


        val dataContainer9 = VPanel(spacing = 10).bind(dataState9) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.gutenacht,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.gutenacht) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState9.value = dataState9.value.copy(
                            list = state.list.mapIndexed { index, dataModel9 -> if (index == idx) dataModel9.copy(gutenacht = this.value) else dataModel9}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer9)


        val dataContainer10 = VPanel(spacing = 10).bind(dataState10) { state ->
            state.list.filter { model ->
                state.searchFilter?.let {
                    trans(model.text).contains(it, ignoreCase = true)
                } ?: true
            }.forEach { model ->
                checkBox(
                    value = model.gutenmorgen,
                    label = model.text
                ) {
                    flabel.fontWeight = if (model.gutenmorgen) FontWeight.BOLD else null
                    style = CheckStyle.PRIMARY
                    marginTop = 50.px
                    marginBottom = 50.px
                    onClick {
                        val idx = state.list.indexOf(model)
                        dataState10.value = dataState10.value.copy(
                            list = state.list.mapIndexed { index, dataModel10 -> if (index == idx) dataModel10.copy(gutenmorgen = this.value) else dataModel10}
                        )
                    }
                }
            }
        }
        panel.add(dataContainer10)


        button(I18n.tr("Hallo"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState1.value = dataState1.value.copy(list = dataState1.value.list.filter { !it.hallo })
            }
        }

        //button(tr("Tschüss"), style = ButtonStyle.DANGER).onClick {
        //  dataState2.value = dataState2.value.copy(list = dataState2.value.list.filter { !it.tschuess})
        //}

        button(I18n.tr("Tschüss"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState2.value = dataState2.value.copy(list = dataState2.value.list.filter { !it.tschuess})
            }
        }

        button(I18n.tr("gehen"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState3.value = dataState3.value.copy(list = dataState3.value.list.filter { !it.gehen})
            }
        }

        button(I18n.tr("sitzen"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState4.value = dataState4.value.copy(list = dataState4.value.list.filter { !it.sitzen})
            }
        }

        button(I18n.tr("Mädchen"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState5.value = dataState5.value.copy(list = dataState5.value.list.filter { !it.maedchen})
            }
        }

        button(I18n.tr("Junge"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState6.value = dataState6.value.copy(list = dataState6.value.list.filter { !it.junge})
            }
        }

        button(I18n.tr("Tisch"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState7.value = dataState7.value.copy(list = dataState7.value.list.filter { !it.tisch})
            }
        }

        button(I18n.tr("Stuhl"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState8.value = dataState8.value.copy(list = dataState8.value.list.filter { !it.stuhl})
            }
        }

        button(I18n.tr("Gute Nacht"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState9.value = dataState9.value.copy(list = dataState9.value.list.filter { !it.gutenacht})
            }
        }

        button(I18n.tr("Guten Morgen"), style = ButtonStyle.SECONDARY) {
            margin = 20.px
            fontSize = 15.px
            fontFamily = "Arial"
            marginBottom = 50.px
            background = Background(Color.name(Col.PEACHPUFF))
            onClick {
                dataState10.value = dataState10.value.copy(list = dataState10.value.list.filter { !it.gutenmorgen})
            }
        }


        vPanel(justify = JustifyContent.SPACEAROUND, alignItems = AlignItems.CENTER, spacing = 50) {
            button(I18n.tr("Aufgabenstellung"), style = ButtonStyle.OUTLINEDARK) {
                background = Background(Color.name(Col.MISTYROSE))
                alignContent = AlignContent.CENTER
                margin = 2.px
                width = 200.px
                height = 50.px
                marginTop = 20.px
                fontSize = 15.px
                fontFamily = "Arial"
                //background = Background(Color.name(Col.ROSYBROWN))
                onClick {
                    Alert.show(
                        I18n.tr("Aufgabenstellung: Lektion 1, Lesson 3"),
                        "Fügen Sie die richtigen Wortpaare zusammen, indem Sie auf das passende Wort und den passenden Button klicken!",
                        animation = false
                    )
                }
            }
        }
    }
    companion object {
        fun run(container: Container) {
            container.add(AufgabeDrei())
        }
    }
}

