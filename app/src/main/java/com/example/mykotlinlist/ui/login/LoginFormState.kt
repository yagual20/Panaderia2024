package com.example.mykotlinlist.ui.login

/**
 * Data validation state of the login form.
 */
data class LoginFormState(
    val useremailError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)