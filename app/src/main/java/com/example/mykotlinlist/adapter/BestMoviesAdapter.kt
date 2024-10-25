package com.example.mykotlinlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinlist.BestMovies
import com.example.mykotlinlist.R
import java.util.*

class BestMoviesAdapter(private var bestMoviesList: List<BestMovies>, private val onClickListener: (BestMovies) -> Unit) :
    RecyclerView.Adapter<BestMoviesViewHolder>(), Filterable {

    // Define una variable para almacenar la lista original
    var bestMoviesListFull = bestMoviesList

    // Implementa el método getFilter() de la interfaz Filterable
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = mutableListOf<BestMovies>()

                if (constraint.isNullOrBlank()) {
                    filteredList.addAll(bestMoviesListFull)
                } else {
                    val filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim()
                    for (movie in bestMoviesListFull) {
                        if (movie.nombreDeProducto.toLowerCase(Locale.ROOT).contains(filterPattern)) {
                            filteredList.add(movie)
                        }
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList

                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                bestMoviesList = results?.values as List<BestMovies>
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BestMoviesViewHolder(layoutInflater.inflate(R.layout.item_bestmovies,parent,false))
    }

    override fun onBindViewHolder(holder: BestMoviesViewHolder, position: Int) {
        val item=bestMoviesList[position]
        holder.render(item,onClickListener,)

    }

    override fun getItemCount(): Int = bestMoviesList.size
}
