package com.example.tmdbapp.data.repository.movie.datasource

import com.example.tmdbapp.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMovies(movies: List<Movie>)

}