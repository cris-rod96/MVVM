package com.example.bestmovies.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.bestmovies.R
import com.example.bestmovies.databinding.ActivityMainBinding
import com.example.bestmovies.ui.viewmodel.MovieViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val movieViewModel : MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel.onCreate()

        movieViewModel.movieModel.observe(this, Observer { currentMovie ->
            binding.tvTitle.text = currentMovie.title
            binding.tvDirector.text = currentMovie.director
            Picasso.get().load(currentMovie.poster).fit().into(binding.movieAvatar)
        })


        movieViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
            binding.layout.isVisible = !it
        })


        binding.layout.setOnClickListener {
            movieViewModel.randomMovie()
        }

    }
}