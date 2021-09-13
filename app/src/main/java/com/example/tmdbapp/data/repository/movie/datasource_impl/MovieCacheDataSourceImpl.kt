package com.example.tmdbapp.data.repository.movie.datasource_impl

import com.example.tmdbapp.data.model.movie.Movie
import com.example.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import javax.inject.Inject

class MovieCacheDataSourceImpl @Inject constructor(): MovieCacheDataSource {

    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> = moviesList

    override suspend fun saveMovies(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}