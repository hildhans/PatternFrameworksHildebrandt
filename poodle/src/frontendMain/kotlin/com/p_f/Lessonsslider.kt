package com.p_f

import io.kvision.core.*
import io.kvision.html.Tag
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.panel.hPanel
import io.kvision.toolbar.buttonGroup
import io.kvision.toolbar.toolbar
import io.kvision.utils.perc


fun Container.lessonsSlider(value: String): Tag {
    return div(value).apply {

        hPanel(wrap = FlexWrap.WRAP, spacing = 100) {
            toolbar {
                buttonGroup {
                    button("1") {
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                }
                buttonGroup {
                    button("2", disabled = true){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("3"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("4"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("5"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("6"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("7"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("8"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("9"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                    button("10"){
                        marginLeft = 4.perc
                        background = Background(Color.name(Col.ROSYBROWN))
                    }
                }
            }

        }
    }
}
