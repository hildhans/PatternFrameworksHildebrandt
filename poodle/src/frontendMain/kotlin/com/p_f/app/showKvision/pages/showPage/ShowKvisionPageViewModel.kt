package com.p_f.app.showKvision.pages.showPage

import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope

class ShowKvisionPageViewModel(
    coroutineScope: CoroutineScope,
    configBuilder: BallastViewModelConfiguration.Builder,
    inputHandler: ShowKvisionPageInputHandler,
    eventHandler: ShowKvisionPageEventHandler
) : BasicViewModel<
        ShowKvisionPageContract.Inputs,
        ShowKvisionPageContract.Events,
        ShowKvisionPageContract.State>(
    coroutineScope = coroutineScope,
    config = configBuilder
        .withViewModel(
            inputHandler = inputHandler,
            initialState = ShowKvisionPageContract.State(),
            name = "ShowKvisionPage",
        )
        .build(),
    eventHandler = eventHandler,
)
