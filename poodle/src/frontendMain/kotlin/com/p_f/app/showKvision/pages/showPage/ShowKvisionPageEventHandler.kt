package com.p_f.app.showKvision.pages.showPage

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope
import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.copperleaf.ballast.navigation.routing.pathParameter
import com.p_f.app.AppRouter
import com.p_f.app.AppRouterViewModel
import com.p_f.app.contacts.pages.contactAdd.ContactAddPageContract
import io.kvision.toast.Toast

class ShowKvisionPageEventHandler(
    private val routerViewModel: AppRouterViewModel
) : EventHandler<
        ShowKvisionPageContract.Inputs,
        ShowKvisionPageContract.Events,
        ShowKvisionPageContract.State> {
    override suspend fun EventHandlerScope<
            ShowKvisionPageContract.Inputs,
            ShowKvisionPageContract.Events,
            ShowKvisionPageContract.State>.handleEvent(
        event: ShowKvisionPageContract.Events
    ) = when (event) {
        is ShowKvisionPageContract.Events.ErrorMessage -> {
            Toast.danger(event.message)
        }
        is ShowKvisionPageContract.Events.SuccessMessage -> {
            Toast.danger(event.message)
        }
    }
}
