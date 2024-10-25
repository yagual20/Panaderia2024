package com.example.mykotlinlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import androidx.webkit.WebViewClientCompat
import com.example.mykotlinlist.productos.Productos
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class VerInformacion : AppCompatActivity() {
    private lateinit var webWiew: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_informacion)

        webWiew = findViewById(R.id.textView3)
        val url = intent.getStringExtra("productos")
        val url2 = intent.getStringExtra("productosMercadona")
        //obtener el valor de url2 en una variable String y remplazar la , por \n
        //para que me salga por pantalla en lineas separadas
        val mercadona = url2?.replace(",","\n") as String
        //Carrefour
        val carr1 = intent.getStringExtra("productosCarrefour")
        val carrefour = carr1?.replace(",","\n") as String

        //negrita al webview
        webWiew.setTextColor(0xFF000000.toInt()) //rojo en hexadecima
        //aumentar el tamaño de la letra
        webWiew.textSize = 15F
        webWiew.append("Productos de Mercadona: \n")
        //pero las letras en negrita
        //ahora normal

        webWiew.append("\n"+mercadona)//me devuelve toda la lista de productos pero
        //tengo que modificarla para que me devulva por marca..
        //println(url)
        //Carrefour
        webWiew.append("\n\nProductos de Carrefour: \n")
        webWiew.append("\n"+carrefour)


        //for para mostrar por pantalla el array por

        ///metodo para el boton

        val botonGenerarDoc = findViewById<TextView>(R.id.btn_ver_pdf)
        //este boton me va a generar un txt con el valor que este en webview

        botonGenerarDoc.setOnClickListener() {
            val rutaDelArchivo = this.getExternalFilesDir("layout")
            val archivo = File(rutaDelArchivo, "listaDeCompra.txt")
            archivo.createNewFile()
            val escritor = BufferedWriter(FileWriter(archivo))
            escritor.write(webWiew.text.toString())
            escritor.close()
            Toast.makeText(this, "Archivo guardado", Toast.LENGTH_SHORT).show()


        }




    }
}