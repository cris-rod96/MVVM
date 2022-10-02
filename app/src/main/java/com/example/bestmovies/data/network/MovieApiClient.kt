package com.example.bestmovies.data.network

import com.example.bestmovies.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("/.json")

    suspend fun getAllMovies(): Response<List<MovieModel>>
}