package com.p_f


import com.p_f.Lessons.*
import io.kvision.core.*
import io.kvision.html.ButtonStyle
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
                    button("1", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc

                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeEins.run(this@lessonsSlider)
                        }
                    }
                    button("2", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeZwei.run(this@lessonsSlider)
                        }
                    }
                    button("3", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeDrei.run(this@lessonsSlider)
                        }
                    }
                    button("4", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeVier.run(this@lessonsSlider)
                        }
                    }
                    button("5", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeFuenf.run(this@lessonsSlider)
                        }
                    }
                    button("6", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeSechs.run(this@lessonsSlider)
                        }
                    }
                    button("7", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeSieben.run(this@lessonsSlider)
                        }
                    }
                    button("8", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeAcht.run(this@lessonsSlider)
                        }
                    }
                    button("9", style = ButtonStyle.OUTLINEDARK) {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                        onClick {
                            AufgabeNeun.run(this@lessonsSlider)
                        }
                    }
                    button("10", style = ButtonStyle.OUTLINEDARK) {
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
