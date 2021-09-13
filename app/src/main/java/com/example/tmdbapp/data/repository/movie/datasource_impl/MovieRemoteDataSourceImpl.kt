package com.example.tmdbapp.data.repository.movie.datasource_impl

import com.example.tmdbapp.data.api.TMDBService
import com.example.tmdbapp.data.model.movie.MovieList
import com.example.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val tmdbService: TMDBService):
    MovieRemoteDataSource {
    override suspend fun getMoviesFromApi(): Response<MovieList> {
        return tmdbService.getPopularMovies()
    }
}