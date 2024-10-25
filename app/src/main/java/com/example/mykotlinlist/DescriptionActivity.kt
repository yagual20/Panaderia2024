package com.example.mykotlinlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DescriptionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        //val moviesTitle = intent.getStringExtra("trailer")
        //val informacion = intent.getStringExtra("informacion_en_film_affinity")

        val productos = intent.getStringExtra("productos")
        val productosMercadona = intent.getStringExtra("productosMercadona")
        val productosCarrefour = intent.getStringExtra("productosCarrefour")
        val productosLidl = intent.getStringExtra("productosLidl")
        val productosDia = intent.getStringExtra("productosDia")
        val productosAldi = intent.getStringExtra("productosAldi")


        //boton ver informacion
        val btnVerInformacion = findViewById<Button>(R.id.btn_ver_pdf)
        btnVerInformacion.setOnClickListener {
            val intent = Intent(this, VerInformacion::class.java)
            intent.putExtra("productos", productos.toString())
            intent.putExtra("productosMercadona", productosMercadona.toString())
            intent.putExtra("productosCarrefour", productosCarrefour.toString())
            intent.putExtra("productosLidl", productosLidl.toString())
            intent.putExtra("productosDia", productosDia.toString())
            intent.putExtra("productosAldi", productosAldi.toString())
            startActivity(intent)
        }




    }
}