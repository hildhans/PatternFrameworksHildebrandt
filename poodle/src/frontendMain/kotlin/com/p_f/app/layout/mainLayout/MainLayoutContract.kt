package com.p_f.app.layout.mainLayout

object MainLayoutContract {
    data class State(
        val loading: Boolean = false,
    )

    sealed class Inputs {
        object Initialize : Inputs()
        data class LoggedInStateHasChanged(val isLoggedIn: Boolean) : Inputs()
    }

    sealed class Events {
        object NavigateToLogin : Events()
    }
}
