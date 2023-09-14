package com.p_f

import io.kvision.core.Background
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.core.onEvent
import io.kvision.form.FormPanel
import io.kvision.form.formPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.Button
import io.kvision.html.ButtonStyle
import io.kvision.i18n.I18n.tr
import io.kvision.modal.Alert
import io.kvision.modal.Dialog
import io.kvision.remote.Credentials
import io.kvision.remote.LoginService
import io.kvision.remote.SecurityMgr
import io.kvision.utils.ENTER_KEY
import kotlinx.coroutines.launch

class LoginWindow : Dialog<Credentials>(closeButton = false, escape = false, animation = false) {

    private val loginPanel: FormPanel<Credentials>
    private val loginButton: Button
    private val userButton: Button
    private val registerPanel: FormPanel<User>
    private val registerButton: Button
    private val cancelButton: Button

    init {

        loginPanel = formPanel {
            add(Credentials::username, Text(label = "${tr("Login")}:"), required = true)
            add(Credentials::password, Password(label = "${tr("Password")}:"), required = true)
            onEvent {
                keydown = {
                    if (it.keyCode == ENTER_KEY) {
                        this@LoginWindow.processCredentials()
                    }
                }
            }
        }
        registerPanel = formPanel {
            add(User::name, Text(label = "${tr("Your name")}:"), required = true)
            add(User::username, Text(label = "${tr("Login:")}:"), required = true)
            add(
                User::password, Password(label = "${tr("Password")}:"), required = true,
                validatorMessage = { "Password too short" }) {
                (it.getValue()?.length ?: 0) >= 8
            }
            add(User::password2, Password(label = "${tr("Confirm password")}:"), required = true,
                validatorMessage = { tr("Password too short") }) {
                (it.getValue()?.length ?: 0) >= 8
            }
            validator = {
                val result = it[User::password] == it[User::password2]
                if (!result) {
                    it.getControl(User::password)?.validatorError = tr("Passwords are not the same")
                    it.getControl(User::password2)?.validatorError = tr("Passwords are not the same")
                }
                result
            }
            validatorMessage = { tr("Passwords are not the same") }

        }
        cancelButton = Button(tr("Cancel"), "fas fa-times", style = ButtonStyle.OUTLINEDARK) {
            background = Background(Color.name(Col.MISTYROSE))
            onClick {
                this@LoginWindow.hideRegisterForm()
            }
        }
        registerButton = Button(tr("Register"), "fas fa-check", style = ButtonStyle.OUTLINEDARK) {
            background = Background(Color.name(Col.MISTYROSE))
            onClick {
                this@LoginWindow.processRegister()
            }
        }
        loginButton = Button(tr("Login"), "fas fa-check", style = ButtonStyle.OUTLINEDARK) {
            background = Background(Color.name(Col.MISTYROSE))
            onClick {
                this@LoginWindow.processCredentials()
            }
        }
        userButton = Button(tr("Register user"), "fas fa-user", style = ButtonStyle.OUTLINEDARK) {
            background = Background(Color.name(Col.MISTYROSE))
            onClick {
                this@LoginWindow.showRegisterForm()
            }
        }
        addButton(userButton)
        addButton(loginButton)
        addButton(cancelButton)
        addButton(registerButton)
        hideRegisterForm()
    }

    private fun showRegisterForm() {
        loginPanel.hide()
        registerPanel.show()
        registerPanel.clearData()
        loginButton.hide()
        userButton.hide()
        cancelButton.show()
        registerButton.show()
    }

    private fun hideRegisterForm() {
        loginPanel.show()
        registerPanel.hide()
        loginButton.show()
        userButton.show()
        cancelButton.hide()
        registerButton.hide()
    }

    private fun processCredentials() {
        if (loginPanel.validate()) {
            setResult(loginPanel.getData())
            loginPanel.clearData()
        }
    }

    private fun processRegister() {
        if (registerPanel.validate()) {
            val userData = registerPanel.getData()
            AppScope.launch {
                if (Model.registerUser(userData, userData.password!!)
                ) {
                    Alert.show(text = tr("Nutzer registriert. Sie können sich nun einloggen.")) {
                        hideRegisterForm()
                    }
                } else {
                    Alert.show(text = tr("Dieser Login ist nicht verfügbar. Bitte versuchen Sie es erneut."))
                }
            }
        }
    }
}

object Security : SecurityMgr() {

    private val loginService = LoginService("/login")
    private val loginWindow = LoginWindow()

    override suspend fun login(): Boolean {
        return loginService.login(loginWindow.getResult())
    }

    override suspend fun afterLogin() {
        Model.readUser()
    }
}
