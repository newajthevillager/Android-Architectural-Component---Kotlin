package com.example.explorejetpackcomponents.data_binding.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.explorejetpackcomponents.R
import com.example.explorejetpackcomponents.data_binding.models.Movie
import com.example.explorejetpackcomponents.databinding.MovieItemBinding

class MovieAdapter(var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var binding : MovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        );
        return MovieViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movie: Movie = movies.get(position)
        var binding: MovieItemBinding? = DataBindingUtil.bind<MovieItemBinding>(holder.itemView)
        binding?.movie = movie
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}