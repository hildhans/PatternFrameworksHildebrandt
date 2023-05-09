package com.p_f.app.showKvision.pages.showPage

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import kotlinx.coroutines.delay

class ShowKvisionPageInputHandler : InputHandler<
        ShowKvisionPageContract.Inputs,
        ShowKvisionPageContract.Events,
        ShowKvisionPageContract.State> {

    override suspend fun InputHandlerScope<
            ShowKvisionPageContract.Inputs,
            ShowKvisionPageContract.Events,
            ShowKvisionPageContract.State>.handleInput(
        input: ShowKvisionPageContract.Inputs
    ) = when (input) {
        is ShowKvisionPageContract.Inputs.Initialize -> {
            updateState { it.copy(loading = true) }
            delay(1000)
            updateState { it.copy(loading = false) }
        }


        is ShowKvisionPageContract.Inputs.SuccessMessage -> {
            postEvent(ShowKvisionPageContract.Events.SuccessMessage(input.message))
        }

        is ShowKvisionPageContract.Inputs.ErrorMessage -> {
            postEvent(ShowKvisionPageContract.Events.ErrorMessage(input.message))
        }
    }
}
