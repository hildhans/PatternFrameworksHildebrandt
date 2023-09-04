package com.p_f


import io.kvision.core.*
import io.kvision.html.Tag
import io.kvision.html.div
import io.kvision.utils.px
import io.kvision.form.formPanel
import io.kvision.form.upload.BootstrapUpload
import io.kvision.i18n.I18n.tr
import io.kvision.rest.RestClient
import io.kvision.types.KFile
import kotlinx.serialization.Serializable
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.utils.perc

@Serializable
data class Form(
    val upload: List<KFile>? = null
)

fun Container.configurationContainer(value: String): Tag {
    return div(value).apply {
        justifyContent = JustifyContent.CENTER
        background = Background(Color.name(Col.MISTYROSE))
        marginTop = 60.px
        width = 900.px
        height = 600.px
        marginLeft = 100.px

        div(value).apply {
            marginTop = 10.perc
            justifyContent = JustifyContent.CENTER
            background = Background(Color.name(Col.MISTYROSE))
            val restClient = RestClient()
            this.marginTop = 10.px
            val formPanel = formPanel<Form> {
                add(
                    Form::upload,
                    BootstrapUpload("/", multiple = true, label = tr("Profilbild hochladen (nur Bilder)")).apply {
                        showUpload = false
                        showCancel = false
                        explorerTheme = true
                        dropZoneEnabled = false
                        allowedFileTypes = setOf("image")
                    })
            }
        }
    }
}