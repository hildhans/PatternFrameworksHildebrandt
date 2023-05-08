package com.p_f.app.layout.shared.appHeader

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import com.copperleaf.ballast.observeFlows
import com.p_f.repository.auth.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map

class AppHeaderInputHandler(
    private val authRepository: AuthRepository
) : InputHandler<
        AppHeaderContract.Inputs,
        AppHeaderContract.Events,
        AppHeaderContract.State> {
    override suspend fun InputHandlerScope<
            AppHeaderContract.Inputs,
            AppHeaderContract.Events,
            AppHeaderContract.State>.handleInput(
        input: AppHeaderContract.Inputs
    ) = when (input) {
        is AppHeaderContract.Inputs.Initialize -> {
            observeFlows(
                key = "[AppHeader] Observing Auth State",
                authRepository
                    .isLoggedIn()
                    .map { AppHeaderContract.Inputs.LoggedInStateHasChanged(it) }
            )
        }

        is AppHeaderContract.Inputs.LoggedInStateHasChanged -> {
            updateState { it.copy(isLoggedIn = input.isLoggedIn) }
        }

        is AppHeaderContract.Inputs.LogOut -> {
            authRepository.logOut()
            postEvent(AppHeaderContract.Events.NavigateToLogin)
        }
    }
}
