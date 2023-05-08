package com.p_f.app.auth.pages.login

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import com.p_f.dto.AuthLoginRequestDto
import com.p_f.endpoints.IAuthEndpointService
import com.p_f.repository.auth.AuthRepository

class LoginPageInputHandler(
    private val authEndpointService: IAuthEndpointService,
    private val authRepository: AuthRepository
) : InputHandler<
        LoginPageContract.Inputs,
        LoginPageContract.Events,
        LoginPageContract.State> {
    override suspend fun InputHandlerScope<
            LoginPageContract.Inputs,
            LoginPageContract.Events,
            LoginPageContract.State>.handleInput(
        input: LoginPageContract.Inputs
    ) = when (input) {
        is LoginPageContract.Inputs.AttemptLogin -> {
            updateState { it.copy(formSubmitting = true) }

            val apiResult = runCatching {
                authEndpointService.login(
                    AuthLoginRequestDto(
                        email = input.email,
                        password = input.password
                    )
                )
            }.getOrElse {
                Result.failure(it)
            }

            apiResult.fold({ response ->
                // Save Access Token and Redirect to Dashboard
                authRepository.login(
                    accessToken = response.accessToken,
                    userData = response.user
                )
                updateState { it.copy(formSubmitting = false) }
                postEvent(LoginPageContract.Events.ShowSuccess("Login Successful. Redirecting..."))
                postEvent(LoginPageContract.Events.NavigateToDashboard)
            }, { error ->
                console.log("Login Credentials Incorrect!")
                updateState { it.copy(formSubmitting = false) }
                postEvent(LoginPageContract.Events.ShowError(error.message ?: "API Error!"))
            })
        }

        is LoginPageContract.Inputs.ShowError -> {
            postEvent(LoginPageContract.Events.ShowError(input.message))
        }

        is LoginPageContract.Inputs.ShowSuccess -> {
            postEvent(LoginPageContract.Events.ShowSuccess(input.message))
        }
    }
}
