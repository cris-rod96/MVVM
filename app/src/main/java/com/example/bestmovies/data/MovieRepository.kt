package com.example.bestmovies.data

import com.example.bestmovies.data.model.MovieModel
import com.example.bestmovies.data.model.MovieProvider
import com.example.bestmovies.data.network.MovieService

class MovieRepository {
    private val movieService = MovieService()

    suspend fun getAllMovies() : List<MovieModel>{
        val response = movieService.getMovies()
        MovieProvider.movies = response
        return response
    }
}