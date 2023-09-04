package com.p_f

import io.kvision.core.Background
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.onEvent
import io.kvision.form.FormPanel
import io.kvision.form.formPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.ButtonStyle
import io.kvision.html.InputType
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.i18n.I18n
import io.kvision.i18n.I18n.tr
import io.kvision.modal.Alert
import io.kvision.panel.HPanel
import io.kvision.utils.ENTER_KEY
import io.kvision.utils.px
import kotlinx.coroutines.launch
import io.kvision.panel.StackPanel
import io.kvision.state.bind
import io.kvision.toast.*


object UserSettingPanel : StackPanel() {

    private var editingId: Int? = null

    private val formEditPanel: FormPanel<Address>
    private val formChangePanel: FormPanel<User>

    init {
        padding = 10.px

        formEditPanel = formPanel { }
        formChangePanel = formPanel {  }
    }

    fun add_teilEDITF(){
        formEditPanel.add(Address::firstName, Text(label = "${tr("First name")}:").apply { maxlength = 255 })
        formEditPanel.add(Address::lastName, Text(label = "${tr("Last name")}:").apply { maxlength = 255 })
    }

    fun add_teilEDITL(){
        formEditPanel.add(Address::email, Text(InputType.EMAIL, label = "${tr("E-mail")}:").apply { maxlength = 255 }) {
            it.getValue()
                ?.let {
                    "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])".toRegex()
                        .matches(it)
                }
        }
        formEditPanel.add(Address::bio, Text(label = "${tr("Bio")}:").apply { maxlength = 255 })
        formEditPanel.add(Address::phone, Text(label = "${tr("Phone number")}:").apply { maxlength = 255 })
        formEditPanel.add(Address::postalAddress, Text(label = "${tr("Postal address")}:").apply { maxlength = 255 })
        formEditPanel.add(HPanel(spacing = 10) {
            button(tr("speichern"), "fas fa-check", style = ButtonStyle.OUTLINEDARK).onClick {
                background = Background(Color.name(Col.MISTYROSE))
                this@UserSettingPanel.saveEdit()
            }
            button(tr("abbrechen"), "fas fa-times", style = ButtonStyle.OUTLINEDARK).onClick {
                background = Background(Color.name(Col.MISTYROSE))
                this@UserSettingPanel.close()
            }
        })
        onEvent {
            keydown = {
                if (it.keyCode == ENTER_KEY) {
                    this@UserSettingPanel.saveEdit()
                }
            }
        }
    }

    fun add_teilEDIT(){
        add_teilEDITF()
        add_teilEDITL()
    }

    fun add_teilADD(){
        add_teilEDITF()
        formEditPanel.add(Address::userName, Text(label = "${tr("Login")}:").apply { maxlength = 255 })
        add_teilEDITL()
    }

    fun add_teilCHANGE(){
        formChangePanel.add(User::name, Text(label = "${tr("Name")}:").apply { maxlength = 255 })
        formChangePanel.add(User::username, Text(label = "${tr("Login:")}:").apply { maxlength = 255 })
        formChangePanel.add(User::password, Password(label = "${tr("New Password")}:"), required = true,
            validatorMessage = { "Password too short" }) {
            (it.getValue()?.length ?: 0) >= 8
        }
        formChangePanel.add(HPanel(spacing = 10) {
            button(tr("speichern"), "fas fa-check", style = ButtonStyle.OUTLINEDARK).onClick {
                background = Background(Color.name(Col.MISTYROSE))
                this@UserSettingPanel.saveEdit()
            }
            button(tr("abbrechen"), "fas fa-times", style = ButtonStyle.OUTLINEDARK).onClick {
                background = Background(Color.name(Col.MISTYROSE))
                this@UserSettingPanel.close()
            }
        })
        onEvent {
            keydown = {
                if (it.keyCode == ENTER_KEY) {
                    this@UserSettingPanel.saveChange()
                }
            }
        }
    }

    fun add() {
        clearing()
        add_teilADD()
        formEditPanel.clearData()
        openEdit(null)
    }

    fun edit(index: Int) {
        val address = Model.userAddress[index]
        clearing()
        add_teilEDIT()
        formEditPanel.setData(address)
        openEdit(address.id)
    }

    fun clearing(){
        formEditPanel.removeAll()
        formEditPanel.reset()
        formChangePanel.removeAll()
        formChangePanel.reset()
    }

    private fun saveEdit() {
        if (formEditPanel.validate()) {
            val address = formEditPanel.getData()
            AppScope.launch {
                if (editingId != null) {
                    Model.updateUserAddress(address.copy(id = editingId))
                    Toast.success(
                        "Die Änderung für "+ address.userName + " wurde gespeichert",
                        options = ToastOptions(
                            position = ToastPosition.BOTTOMRIGHT,
                            close = true,
                            duration = 10000
                        )
                    )
                } else {
                    Model.addUserAddress(address)
                    Toast.success(
                        "User angelegt mit: "+ address.userName + " und das Startpasswort: Start_12345",
                        options = ToastOptions(
                            position = ToastPosition.BOTTOMRIGHT,
                            close = true,
                            duration = 10000
                        )
                    )
                }
                close()
            }
        }
    }

    fun delete(index: Int) {
        AppScope.launch {
            close()
            Model.userAddress[index].id?.let {
                Model.deleteUserAddress(it)
            }
        }
    }

    private fun openEdit(editingId: Int?) {
        this.editingId = editingId
        activeChild = formEditPanel
        formEditPanel.validate()
        formEditPanel.getControl(Address::firstName)?.focus()
    }

    fun change() {
        clearing()
        add_teilCHANGE()
        div().bind(Model.user) { user ->
            if (user.name != null) {
                formChangePanel.setData(user)
                openChange(user.id)
            }
        }
    }

    private fun saveChange() {
        if (formChangePanel.validate()) {
            val userData = formChangePanel.getData()
            AppScope.launch {
                userData.copy(id = editingId)
                Model.changeUser(userData, userData.password!!)
                Toast.success(
                    "Passwort für "+ userData.username +" geändert!",
                    options = ToastOptions(
                        position = ToastPosition.BOTTOMRIGHT,
                        close = true,
                        duration = 10000
                    )
                )
                close()
            }
        }
    }

    private fun openChange(editingId: Int?) {
        this.editingId = editingId
        activeChild = formChangePanel
        formChangePanel.validate()
        formChangePanel.getControl(User::name)?.focus()
    }

    private fun close() {
        editingId = null
        activeChild = UserAddress
        clearing()
        PoodlePanel.refresh()
        refresh()
    }
}
