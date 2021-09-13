package com.example.tmdbapp.data.repository.movie.datasource

import com.example.tmdbapp.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovies(movies: List<Movie>)
    suspend fun clearAll()

}