package com.example.mykotlinlist.adapter

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mykotlinlist.BestMovies
import com.example.mykotlinlist.databinding.ItemBestmoviesBinding

class BestMoviesViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemBestmoviesBinding.bind(view)





    fun render(bestMoviesModel: BestMovies, onClickListener:(BestMovies)-> Unit) {
        binding.tvBestMoviesName.text = bestMoviesModel.nombreDeProducto
        binding.tvBestMoviesYear.text = "Categoria: "+bestMoviesModel.categoriaDeProducto
        binding.tvBestMoviesDuration.text = "Supermercado: "+bestMoviesModel.supermercado
        binding.tvBestMoviesCountry.text = "Precio: "+bestMoviesModel.precio
        //binding.tvBestMoviesDirector.text = "Director: "+bestMoviesModel.director
        //binding.tvBestMoviesGenre.text = "Supermercado: "+bestMoviesModel.supermercadoNo

        binding.ivBestMoviesImage.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(itemView.context).load(bestMoviesModel.image).into(binding.ivBestMoviesImage)
        //lo mismo pero con el boton es un button
        binding.btnAAdiralCarrito.setOnClickListener{
            onClickListener(bestMoviesModel)

        }
        binding.ivBestMoviesImage.setOnClickListener{
            Toast.makeText(itemView.context, "Se ha eliminado", Toast.LENGTH_SHORT).show()
        }















    }

}
