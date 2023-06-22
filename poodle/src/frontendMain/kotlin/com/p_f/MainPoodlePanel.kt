package com.p_f

import io.kvision.core.onEvent
import io.kvision.form.FormPanel
import io.kvision.form.check.CheckBox
import io.kvision.form.formPanel
import io.kvision.form.text.Text
import io.kvision.html.ButtonStyle
import io.kvision.html.InputType
import io.kvision.html.button
import io.kvision.i18n.I18n
import io.kvision.panel.HPanel
import io.kvision.panel.StackPanel
import io.kvision.utils.ENTER_KEY
import io.kvision.utils.px
import kotlinx.coroutines.launch

object MainPoodlePanel : StackPanel() {
/*
    private var editingId: Int? = null

    private val formPanel: FormPanel<Address>

    init {
        padding = 10.px

        formPanel = formPanel {
            add(Address::firstName, Text(label = "${I18n.tr("First name")}:").apply { maxlength = 255 })
            add(Address::lastName, Text(label = "${I18n.tr("Last name")}:").apply { maxlength = 255 })
            add(Address::email, Text(InputType.EMAIL, label = "${I18n.tr("E-mail")}:").apply { maxlength = 255 }) {
                it.getValue()
                    ?.let {
                        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])".toRegex()
                            .matches(it)
                    }
            }
            add(Address::phone, Text(label = "${I18n.tr("Phone number")}:").apply { maxlength = 255 })
            add(Address::postalAddress, Text(label = "${I18n.tr("Postal address")}:").apply { maxlength = 255 })
            add(Address::bio, Text(label = "${I18n.tr("bio")}:").apply { maxlength = 255 })
            add(Address::userimage, Text(label = "${I18n.tr("image")}:").apply { maxlength = 255 })

            add(HPanel(spacing = 10) {
                button(I18n.tr("Save"), "fas fa-check", ButtonStyle.PRIMARY).onClick {
                    this@MainPoodlePanel.save()
                }
                button(I18n.tr("Cancel"), "fas fa-times", ButtonStyle.SECONDARY).onClick {
//                    this@MainPoodlePanel.close()
                }
            })
            onEvent {
                keydown = {
                    if (it.keyCode == ENTER_KEY) {
                        this@MainPoodlePanel.save()
                    }
                }
            }
        }
        //add(ActionPanel)
    }

    fun add() {
        formPanel.clearData()
        open(null)
    }

    fun edit(index: Int) {
        val address = Model.userAddress[index]
        formPanel.setData(address)
        open(address.id)
    }

    private fun save() {
        AppScope.launch {
            if (formPanel.validate()) {
                val address = formPanel.getData()
                if (editingId != null) {
                    Model.updateUserAddress(address.copy(id = editingId))
                } else {
                    Model.addUserAddress(address)
                }
                //close()
            }
        }
    }

    fun delete(index: Int) {
        AppScope.launch {
            //close()
            Model.deleteUserAddress(index)
        }
    }

    private fun open(editingId: Int?) {
        this.editingId = editingId
        activeChild = formPanel
        formPanel.validate()
        formPanel.getControl(Address::firstName)?.focus()
    }

    private fun close() {
        editingId = null
        activeChild = ActionPanel
    }*/
}