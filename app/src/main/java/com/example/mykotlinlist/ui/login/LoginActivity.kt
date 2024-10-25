package com.example.mykotlinlist.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mykotlinlist.databinding.ActivityLoginBinding
import android.util.Log
import com.example.mykotlinlist.R
import com.example.mykotlinlist.maps.MapActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    private lateinit var botonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailUser = binding.useremail
        val password = binding.password
        val login = binding.login
        val loading = binding.loading
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // Desactiva el botón de login si el correo o la contraseña no son válidos
            login.isEnabled = loginState.isDataValid

            // Mostrar el error en el campo de correo electrónico si es necesario
            if (loginState.useremailError != null) {
                emailUser?.error = getString(loginState.useremailError)
            }

            // Mostrar el error en el campo de contraseña si es necesario
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })


        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

            // Complete and destroy login activity once successful
            //finish()
        })



        login.setOnClickListener {
            try {
                loading.visibility = View.VISIBLE
                loginViewModel.login(emailUser?.text.toString(), password.text.toString())
            } catch (e: Exception) {
                Log.e("LoginActivity", "Error al iniciar sesión", e)
                Toast.makeText(this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            }
        }


        botonLogin = findViewById(R.id.login)
        botonLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, MapActivity::class.java)
            startActivity(intent)
        }

        emailUser?.afterTextChanged {
            loginViewModel.loginDataChanged(
                emailUser.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    emailUser?.text.toString(),
                    password.text.toString()
                )
            }





            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            emailUser?.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }
        }

    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}
