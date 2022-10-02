package com.example.bestmovies.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://bestmoviesapi-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}