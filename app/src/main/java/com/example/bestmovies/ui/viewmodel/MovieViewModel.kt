package com.example.bestmovies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestmovies.data.model.MovieModel
import com.example.bestmovies.data.model.MovieProvider
import com.example.bestmovies.domain.GetMovieUseCase
import com.example.bestmovies.domain.GetRandomMovieUseCase
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {


    val movieModel = MutableLiveData<MovieModel>()
    val isLoading = MutableLiveData<Boolean>()
    var getMovieUseCase = GetMovieUseCase()
    var getRandomMovieUseCase = GetRandomMovieUseCase()

    fun onCreate(){

        viewModelScope.launch {
            isLoading.postValue(true)
            val movies = getMovieUseCase()
            if(!movies.isNullOrEmpty()){
                movieModel.postValue(movies[0])
                isLoading.postValue(false)
            }
        }

    }


    fun randomMovie(){
        viewModelScope.launch {
            val currentMovie = getRandomMovieUseCase()
            if(currentMovie != null){
                movieModel.postValue(currentMovie)
            }
        }
    }
}