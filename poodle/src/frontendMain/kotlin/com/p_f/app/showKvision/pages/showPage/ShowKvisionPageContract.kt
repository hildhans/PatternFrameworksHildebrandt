package com.p_f.app.showKvision.pages.showPage

object ShowKvisionPageContract {
    data class State(
        val loading: Boolean = false,
    )

    sealed class Inputs {
        object Initialize : Inputs()
        data class SuccessMessage(val message: String) : Inputs()
        data class ErrorMessage(val message: String) : Inputs()
    }

    sealed class Events {
        data class SuccessMessage(val message: String) : Events()
        data class ErrorMessage(val message: String) : Events()
    }
}
