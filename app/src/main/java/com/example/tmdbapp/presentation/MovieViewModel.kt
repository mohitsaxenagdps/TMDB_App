package com.example.tmdbapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbapp.domain.usecase.GetMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdateMoviesUseCase
import javax.inject.Inject

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}