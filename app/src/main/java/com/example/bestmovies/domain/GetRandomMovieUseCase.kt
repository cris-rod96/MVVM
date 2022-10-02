package com.example.bestmovies.domain

import com.example.bestmovies.data.MovieRepository
import com.example.bestmovies.data.model.MovieModel
import com.example.bestmovies.data.model.MovieProvider

class GetRandomMovieUseCase {



    operator fun invoke(): MovieModel?{
        val movies = MovieProvider.movies

        if(!movies.isNullOrEmpty()){
            val randomNumber = (movies.indices).random()
            return movies[randomNumber]
        }else{
            return null
        }

    }
}