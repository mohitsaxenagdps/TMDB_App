package com.example.tmdbapp.domain.repository

import com.example.tmdbapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}