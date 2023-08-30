package com.p_f


import com.p_f.Lessons.*
import io.kvision.core.*
import io.kvision.html.Align
import io.kvision.html.Tag
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.flexPanel
import io.kvision.toolbar.buttonGroup
import io.kvision.toolbar.toolbar
import io.kvision.utils.perc
import io.kvision.utils.px

fun Container.lessonsSlider(value: String): Tag {
    return div(value, align = Align.CENTER).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.LIGHTGRAY))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px
        val flex = flexPanel(FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.CENTER, AlignItems.CENTER,
            spacing = 5, alignContent = AlignContent.CENTER ) {
            div {
                marginTop = 10.perc
                align = Align.CENTER
                justifyContent = JustifyContent.CENTER
                toolbar {
                    buttonGroup {
                        button("1") {
                            marginLeft = 4.perc

                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeEins.run(this@lessonsSlider)
                            }
                        }
                        button("2") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeZwei.run(this@lessonsSlider)
                            }
                        }
                        button("3") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeDrei.run(this@lessonsSlider)
                            }
                        }
                        button("4") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeVier.run(this@lessonsSlider)
                            }
                        }
                        button("5") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeFuenf.run(this@lessonsSlider)
                            }
                        }
                        button("6") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeSechs.run(this@lessonsSlider)
                            }
                        }
                        button("7") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeSieben.run(this@lessonsSlider)
                            }
                        }
                        button("8") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeAcht.run(this@lessonsSlider)
                            }
                        }
                        button("9") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeNeun.run(this@lessonsSlider)
                            }
                        }
                        button("10") {
                            marginLeft = 4.perc
                            background = Background(Color.name(Col.ROSYBROWN))
                            onClick {
                                AufgabeZehn.run(this@lessonsSlider)
                            }
                        }
                    }
                }
            }
        }
    }
}
