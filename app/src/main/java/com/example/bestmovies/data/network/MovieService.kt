package com.example.bestmovies.data.network

import com.example.bestmovies.core.RetrofitHelper
import com.example.bestmovies.data.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {

    private val retrofit = RetrofitHelper.getRetrofit()


    suspend fun getMovies() : List<MovieModel>{

        return withContext(Dispatchers.IO){
            val movies = retrofit.create(MovieApiClient::class.java).getAllMovies()
            movies.body() ?: emptyList()
        }

    }
}