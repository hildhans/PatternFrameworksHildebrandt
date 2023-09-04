package com.p_f

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.html.image
import io.kvision.html.ImageShape
import io.kvision.html.div
import io.kvision.html.span
import io.kvision.require
import io.kvision.i18n.I18n
import io.kvision.panel.flexPanel
import io.kvision.utils.auto
import io.kvision.core.FlexDirection
import io.kvision.core.FlexWrap
import io.kvision.core.JustifyContent
import io.kvision.html.Align
import io.kvision.html.Tag
import io.kvision.modal.Alert


fun Container.taskBackground(value: String): Tag {
    return div(value, align = Align.CENTER).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.MISTYROSE))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px
        align = Align.CENTER
        val flex = flexPanel(FlexDirection.ROW, FlexWrap.WRAP, JustifyContent.CENTER, AlignItems.CENTER,
        spacing = 5, alignContent = AlignContent.CENTER ) {
            div().apply {
                marginTop = 5.perc
                align = Align.CENTER
                maxWidth = 510.px
                justifyContent = JustifyContent.CENTER
                //background = Background(Color.hex("#F2F2F2", 0.75))
               background = Background(Color.name(Col.MISTYROSE))


                this.marginTop = 10.px

                vPanel(spacing = 3, useWrappers = true, justify = JustifyContent.CENTER) {
                    maxWidth = 500.px
                    div() {
                        //fontFamily = "Bogart"
                        fontFamily = "ABeeZee"
                        fontWeight = FontWeight.BOLDER
                        width = 500.px
                        height =50.px
                        /*span {
                            align = Align.CENTER
                            +I18n.tr("Welcome!")
                        }*/
                    }
                    div() {
                        /*span {
                            fontFamily = "Arial"
                            fontSize = 32.px
                            fontStyle = FontStyle.OBLIQUE
                            fontWeight = FontWeight.BOLDER
                            fontVariant = FontVariant.SMALLCAPS
                            align = Align.CENTER
                            width = 500.px
                            height =80.px
                            textDecoration =
                                TextDecoration(
                                    TextDecorationLine.UNDERLINE,
                                    TextDecorationStyle.DOTTED,
                                    Color.name(Col.RED)
                                )
                            +I18n.tr("Willkommen bei Poodle")
                        }*/
                    }
                    image(require("img/welcomeImage.png"), centered = true) {
                       alignContent = AlignContent.CENTER
                        width =  auto
                        height = auto
                        //maxWidth = 500.px
                        width = 750.px
                        height =450.px
                        /*enablePopover(
                            PopoverOptions(
                                title = I18n.tr("Click on Lessons in the menu to begin"),
                               // content = "UK."
                            )
                        )   */
                        onClick{
                                MainPart.remove(taskBackground(""))
                                MainPart.removeAll()
                                refresh()
                                MainPart.refresh()
                                MainPart.add(sideBar(""))
                                MainPart.add(lessonsTab(""))
                                refresh()
                            Alert.show(
                                I18n.tr("Let's get started!"),
                                I18n.tr("Choose an exercise to start"),
                                animation = false
                            )
                            }

                    }
                    /*image(require("img/GB2.jpg"), centered = true) {
                        alignContent = AlignContent.CENTER
                        width =  auto
                        height = auto
                        maxWidth = 500.px
                        width = 500.px
                        height =170.px
                        enablePopover(
                            PopoverOptions(
                                title = I18n.tr("Flagge"),
                                content = "UK."
                            )
                        )
                    }*/
                }
            }
        }
        //add(lessonsSlider(""))
        //add(aufgabenPool(""))
    }
}

