package com.example.bestmovies.domain

import com.example.bestmovies.data.MovieRepository
import com.example.bestmovies.data.model.MovieModel

class GetMovieUseCase {

    private val repository = MovieRepository()

    suspend operator fun invoke(): List<MovieModel> = repository.getAllMovies()
}