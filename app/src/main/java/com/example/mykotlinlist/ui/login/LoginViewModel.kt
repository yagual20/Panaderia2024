package com.example.mykotlinlist.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.mykotlinlist.data.LoginRepository
import com.example.mykotlinlist.data.Result

import com.example.mykotlinlist.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(useremail: String, password: String) {
        // Can be launched in a separate asynchronous job
        val result = loginRepository.login(useremail, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(useremail: String, password: String) {
        if (!isUserEmailValid(useremail)) {
            _loginForm.value = LoginFormState(useremailError = R.string.invalid_useremail)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }


    // A placeholder email validation check
    private fun isUserEmailValid(useremail: String): Boolean {
        /*return if (useremail.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(useremail).matches()
        } else {
            useremail.isNotBlank()
        }*/
        return Patterns.EMAIL_ADDRESS.matcher(useremail).matches()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 7 && password.any { it.isUpperCase() } && password.any { !it.isLetterOrDigit() }
    }

}
