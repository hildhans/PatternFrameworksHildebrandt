package com.p_f.app.landing.pages.landingPage

object LandingPageContract {
    data class State(
        val loading: Boolean = false,
    )

    sealed class Inputs {
        object Initialize : Inputs()
        object NavigateToContactListPage : Inputs()
    }

    sealed class Events {
        object NavigateToContactListPage : Events()
    }
}
