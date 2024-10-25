package com.example.mykotlinlist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinlist.adapter.BestMoviesAdapter
import com.example.mykotlinlist.databinding.ActivityMainBinding
import com.example.mykotlinlist.productos.Productos


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var productos:ArrayList<Productos> = ArrayList<Productos>()
    //creo variable textview para mostrar por pantalla la lista de productos


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.rvList.adapter?.let { adapter ->
                    if (adapter is BestMoviesAdapter) {
                        adapter.filter.filter(newText)
                    }
                }
                return false
            }
        })

        binding.imageView.setOnClickListener {
            val intent = Intent(this, DescriptionActivity::class.java)
            separarProductosPorSupermercado(productos)
            intent.putExtra("productos", productos.toString())
            intent.putExtra("productosMercadona", productosMercadona.toString())
            intent.putExtra("productosCarrefour", productosCarrefour.toString())
            intent.putExtra("productosLidl", productosLidl.toString())
            intent.putExtra("productosDia", productosDia.toString())
            intent.putExtra("productosAldi", productosAldi.toString())
            startActivity(intent)
        }






    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        DividerItemDecoration(this, manager.orientation)

        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter =
            BestMoviesAdapter(BestMoviesPovider.bestMoviesLists) { bestMovies ->
                onItemSelect(
                    bestMovies
                )
            }
        //para el OnItemLongSelect


    }

    private var imagenCarrito:ImageView? = null
    //arraylist de productos

    //textview que muestra el numero de productos en el carrito
    private var numeroProductos:TextView? = null

    private fun onItemSelect(bestMovies: BestMovies) {
       Toast.makeText(this, bestMovies.nombreDeProducto+" añadido al carrito", Toast.LENGTH_SHORT).show()
        imagenCarrito = findViewById(R.id.imageView3)
        //ponerla en visible
        imagenCarrito?.visibility = ImageView.VISIBLE
        //añadir el producto al arraylist
        productos.add(Productos(bestMovies.nombreDeProducto, bestMovies.categoriaDeProducto, bestMovies.supermercado, bestMovies.precio))
        //cambiar el numero de productos en el carrito
        numeroProductos = findViewById(R.id.textView2)
        //cambiar la visibilidad del textview
        numeroProductos?.visibility = TextView.VISIBLE
        //cambiar el texto del textview
        numeroProductos?.text = encontrarProductosUnicosCount(productos!!)


        //mostrar el numero de productos en el carrito del arraylist
        //numeroProductos?.text = contarProductos()
        Toast.makeText(this, "numero de productos en el carrito: "+encontrarProductosUnicosCount(productos!!), Toast.LENGTH_SHORT).show()

        //val intent = Intent(this, DescriptionActivity::class.java)
        //intent.putExtra("moviesTitle", bestMovies.nombreDeProducto)
        //intent.putExtra("trailer", bestMovies.trailer)
        //intent.putExtra("informacion_en_film_affinity", bestMovies.informacion_en_film_affinity)
        //startActivity(intent)


    }
    //metodo si mantienes seleccionado un producto del recyclerview
    private fun onItemLongSelect(bestMovies: BestMovies) {
        Toast.makeText(
            this,
            bestMovies.nombreDeProducto + " Pulsasion larga",
            Toast.LENGTH_SHORT
        ).show()



    }


    //metodo que solo cuenta los productos que estan en el carrito pero si esta repetido no lo cuenta

    fun encontrarProductosUnicosCount(listaProductos: ArrayList<Productos>): String {
        val productosUnicosSet = HashSet<Productos>()
        productosUnicosSet.addAll(listaProductos)
        return productosUnicosSet.size.toString()
    }
    //separar los productos por supermercado , asi que primero vemos que supermercados hay en el arraylist
    //y luego contamos cuantos productos hay de cada supermercado
    val productosMercadona = ArrayList<Productos>()
    val productosCarrefour = ArrayList<Productos>()
    val productosLidl = ArrayList<Productos>()
    val productosDia = ArrayList<Productos>()
    val productosAldi = ArrayList<Productos>()

    fun separarProductosPorSupermercado(listaProductos: ArrayList<Productos>){

        for (producto in listaProductos) {

            if (producto.supermercado == "Mercadona") {
                productosMercadona.add(producto)
            }
            if (producto.supermercado == "Carrefour") {
                productosCarrefour.add(producto)
            }
            if (producto.supermercado == "Lidl") {
                productosLidl.add(producto)
            }
            if (producto.supermercado == "Dia") {
                productosDia.add(producto)
            }
            if (producto.supermercado == "Aldi") {
                productosAldi.add(producto)
            }
        }
    }






}


