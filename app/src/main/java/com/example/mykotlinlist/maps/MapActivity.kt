package com.example.mykotlinlist.maps

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mykotlinlist.MainActivity
import com.example.mykotlinlist.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var rangeSeekBar: SeekBar
    private lateinit var rangeTextView: TextView

    private lateinit var botonBuscar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        rangeSeekBar = findViewById(R.id.rangeSeekBar)
        rangeTextView = findViewById(R.id.rangeTextView)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        //mi localizacion
        //val currentLatLng = LatLng(37.8644, -0.7913)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        rangeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val rangeText = "$progress km"
                rangeTextView.text = rangeText

                // Realizar búsqueda de supermercados cercanos con el rango seleccionado
                // Llamar a la función que realiza la búsqueda de supermercados pasando el rango seleccionado
                // searchNearbySupermarkets(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //Metodo para abrir otra actividad con el boton
        botonBuscar = findViewById(R.id.btnMapa)
        botonBuscar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true

            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val currentLatLng = LatLng(37.8644, -0.7913)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))

                    // Realizar búsqueda de supermercados cercanos con el rango predeterminado de 5 km
                    // Llamar a la función que realiza la búsqueda de supermercados pasando el rango predeterminado
                    searchNearbySupermarkets(5)
                }
            }
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    // Función para buscar supermercados cercanos
    private fun searchNearbySupermarkets(range: Int) {
        // Aquí puedes implementar tu lógica para buscar supermercados cercanos.
        // Por ejemplo, puedes usar una API de búsqueda de lugares o un conjunto de coordenadas predefinidas.

        // Agregar algunos marcadores de ejemplo
        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(37.8644, -0.7913))
                .title("Supermercado 1")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(37.8794, -0.7913))
                .title("Supermercado 2")
        )
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}












