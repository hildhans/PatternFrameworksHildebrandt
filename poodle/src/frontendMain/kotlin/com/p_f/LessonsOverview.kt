package com.p_f


import io.kvision.core.*
import io.kvision.html.Tag
import io.kvision.html.div
import io.kvision.utils.px
import io.kvision.chart.ChartOptions
import io.kvision.chart.ChartScales
import io.kvision.chart.ChartType
import io.kvision.chart.Configuration
import io.kvision.chart.DataSets
import io.kvision.chart.LegendOptions
import io.kvision.chart.PluginsOptions
import io.kvision.chart.TitleOptions
import io.kvision.chart.chart
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.i18n.I18n.tr
import io.kvision.utils.perc
import kotlin.random.Random

fun Container.lessonsOverview(value: String): Tag {
    return div(value).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.LIGHTGRAY))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px
        div(value).apply {
            marginTop = 10.perc
            justifyContent = JustifyContent.CENTER
            background = Background(Color.name(Col.LIGHTGRAY))
            this.marginTop = 10.px

            chart(
                Configuration(
                    ChartType.BAR,
                    listOf(
                        DataSets(
                            //data = listOf(6, 20, 75, 62, 10, 88, 35, 100, 100, 25)
                            data = List(10) { Random.nextInt(5, 100) }
                            ,
                            backgroundColor = listOf(
                                Color.hex(0x3e95cd),
                                Color.hex(0x8e5ea2),
                                Color.hex(0x3cba9f),
                                Color.hex(0xe8c3b9),
                                Color.hex(0xc45850),
                                Color.hex(0x6e91cd),
                                Color.hex(0x8a5ee2),
                                Color.hex(0x5cbd9a),
                                Color.hex(0xa8c1b1),
                                Color.hex(0x841155)
                            )
                        )
                    ),
                    listOf(
                        tr("Aufgabe 1"),
                        tr("Aufgabe 2"),
                        tr("Aufgabe 3"),
                        tr("Aufgabe 4"),
                        tr("Aufgabe 5"),
                        tr("Aufgabe 6"),
                        tr("Aufgabe 7"),
                        tr("Aufgabe 8"),
                        tr("Aufgabe 9"),
                        tr("Aufgabe 10")
                    ),
                    ChartOptions(
                        plugins = PluginsOptions(
                            legend = LegendOptions(display = false),
                            title = TitleOptions(display = false)
                        ),
                        scales = mapOf("y" to ChartScales(suggestedMin = 0, suggestedMax = 100))
                    )
                ), 420, 280
            )
        }
    }
}