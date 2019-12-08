package com.example.explorejetpackcomponents.data_binding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.explorejetpackcomponents.R
import com.example.explorejetpackcomponents.data_binding.adapters.MovieAdapter
import com.example.explorejetpackcomponents.data_binding.data.MovieData
import com.example.explorejetpackcomponents.data_binding.models.Movie
import com.example.explorejetpackcomponents.databinding.ActivityMainBinding
import com.example.explorejetpackcomponents.databinding.ActivityMoviesBinding

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMoviesBinding = DataBindingUtil.setContentView(this, R.layout.activity_movies);

        var movies : List<Movie> = MovieData.movies

        var adapter: MovieAdapter = MovieAdapter(movies)
        var layoutManager: LinearLayoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        binding.rvMovies.layoutManager = layoutManager
        binding.rvMovies.adapter = adapter

    }
}
