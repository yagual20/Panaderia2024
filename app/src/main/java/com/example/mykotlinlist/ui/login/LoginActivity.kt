package com.example.mykotlinlist.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mykotlinlist.databinding.ActivityLoginBinding
import androidx.appcompat.app.AlertDialog
import com.example.mykotlinlist.R
import com.example.mykotlinlist.maps.MapActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    private lateinit var botonRegistrar: Button
    //texto email
    lateinit var useremail: EditText
    //texto password
    private lateinit var password: EditText

    //Btton Google
    lateinit var botonGoogle: Button
    private val GOOGLE_SIGN_IN = 1000

    //Boton Facebook
    lateinit var botonfb: Button
    private val callbackManager = CallbackManager.Factory.create()

    //Hola prueba

    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash
        Thread.sleep(3000) // HACER UNA ESPERA DE 3 SEGUNDOS
        setTheme(R.style.Theme_MyKotlinList)

        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Analizar el formulario de inicio de sesión
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Se inicio la sesion")

        analytics.logEvent("InitScreen", bundle)


        this.useremail = binding.useremail!!
        password = binding.password
        val login = binding.Login
        val loading = binding.loading
        setup()

    }
    private fun setup(){
        title = "Autenticación"
        botonRegistrar = findViewById(R.id.crearcuenta)
        botonRegistrar.setOnClickListener {
            if (useremail.text.isNotEmpty() && password.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(useremail.text.toString(), password.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        iniciarOtraActividad()
                    }else{
                        showAlert()
                    }
                }
            }else{
                Toast.makeText(this, "Se debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
                }
        }
        botonGoogle = findViewById(R.id.botonGoogle)
        botonGoogle.setOnClickListener {
            //Configuracion
            val googleConf: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id)) //ERROR DE DEFAULT_WEB_CLIENT_ID
                .requestEmail()
                .build()
            val googleClient: GoogleSignInClient = GoogleSignIn.getClient(this, googleConf)
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)

        }


        botonfb.setOnClickListener{
        LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
            LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult> {

                override fun onSuccess(result: LoginResult?) {

                    result?.let {
                        val token = it.accessToken
                        val credential: AuthCredential = FacebookAuthProvider.getCredential(token.token)
                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    iniciarOtraActividad()
                                }else{
                                    showAlert()
                                }
                            }
                    }
                }
                override fun onCancel() {

                }
                override fun onError(error: FacebookException?) {
                        showAlert()
                }
        })
        }

    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this@LoginActivity)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario o Este usuario ya existe")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun iniciarOtraActividad() {
        val intent = Intent(this@LoginActivity, MapActivity::class.java)
        startActivity(intent)
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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

           try {

            val account = task.getResult(ApiException::class.java)
            if (account != null) {
                val credential:AuthCredential = GoogleAuthProvider.getCredential(account.idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            iniciarOtraActividad()
                        }else{
                            showAlert()
                        }
                    }

            }
           } catch (e: ApiException) {
               showAlert()
           }
        }
    }

}


