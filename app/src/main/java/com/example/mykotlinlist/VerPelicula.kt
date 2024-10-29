package com.example.mykotlinlist

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class VerPelicula : AppCompatActivity() {

    private lateinit var webView: WebView
    private var videoView: View? = null
    private var customViewCallback: WebChromeClient.CustomViewCallback? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_pelicula)

        webView = findViewById(R.id.webView1)

        // Cargar la página de YouTube en el WebView
        val videoUrl = intent.getStringExtra("trailer") as String
        webView.loadUrl(videoUrl)
        webView.settings.javaScriptEnabled = true


        webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

    }
}

