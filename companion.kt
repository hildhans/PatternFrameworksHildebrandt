package com.p_f

import io.kvision.core.Border
import io.kvision.core.BorderStyle
import io.kvision.core.Component
import io.kvision.html.Button
import io.kvision.toolbar.ButtonGroup
import io.kvision.utils.px

object companion {
        lateinit var taskBar: ButtonGroup
        fun addTask(window: DesktopWindow): Component {
            val task = Button("1") {
                border = Border(1.px, BorderStyle.SOLID)
                marginLeft = 5.px
                onClick {
                    if(window.minimized) window.toggleMinimize()
                    window.toFront()
                    window.focus()
                }
            }
            taskBar.add(task)
            return task
        }
        fun removeTask(task: Component){
            taskBar.remove(task)
            task.dispose()
        }
    }
