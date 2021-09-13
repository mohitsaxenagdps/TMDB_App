package com.example.tmdbapp.data.repository.movie.datasource_impl

import com.example.tmdbapp.data.db.MovieDao
import com.example.tmdbapp.data.model.movie.Movie
import com.example.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        CoroutineScope(IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            movieDao.deleteMovies()
        }
    }
}