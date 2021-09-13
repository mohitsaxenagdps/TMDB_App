package com.example.tmdbapp.data.repository.movie.datasource

import com.example.tmdbapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMoviesFromApi(): Response<MovieList>

}