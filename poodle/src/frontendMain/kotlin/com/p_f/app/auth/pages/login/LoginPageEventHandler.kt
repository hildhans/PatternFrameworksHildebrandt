package com.p_f.app.auth.pages.login

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope
import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.p_f.app.AppRouter
import com.p_f.app.AppRouterViewModel
import io.kvision.toast.Toast

class LoginPageEventHandler(
    private val appRouterViewModel: AppRouterViewModel
) : EventHandler<
        LoginPageContract.Inputs,
        LoginPageContract.Events,
        LoginPageContract.State> {
    override suspend fun EventHandlerScope<
            LoginPageContract.Inputs,
            LoginPageContract.Events,
            LoginPageContract.State>.handleEvent(
        event: LoginPageContract.Events
    ) = when (event) {
        is LoginPageContract.Events.NavigateToDashboard -> {
            appRouterViewModel
                .trySend(
                    RouterContract.Inputs.GoToDestination(
                        AppRouter.Home.directions().build()
                    )
                )
            Unit
        }

        is LoginPageContract.Events.ShowError -> {
            Toast.danger(event.message)
        }

        is LoginPageContract.Events.ShowSuccess -> {
            Toast.success(event.message)
        }
    }
}
