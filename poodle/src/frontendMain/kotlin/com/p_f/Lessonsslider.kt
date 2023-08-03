package com.p_f


import io.kvision.core.*
import io.kvision.html.Tag
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.HPanel
import io.kvision.toolbar.buttonGroup
import io.kvision.toolbar.toolbar
import io.kvision.utils.perc

object Lessonsslider : HPanel(wrap = FlexWrap.WRAP, spacing = 100 ) {
    init{
      /*  add(lessonsSlider(""))*/
    }
}

fun Container.lessonsSlider(value: String): Tag {
    return div(value).apply {
        marginTop = 4.perc

        div {
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
