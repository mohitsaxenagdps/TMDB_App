package com.example.tmdbapp.data.repository.movie

import android.util.Log
import com.example.tmdbapp.data.model.movie.Movie
import com.example.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromRemoteDataSource()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromRemoteDataSource()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovies(newListOfMovies)
        movieCacheDataSource.saveMovies(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromRemoteDataSource(): List<Movie> {
        var moviesList = emptyList<Movie>()
        try {
            val response = movieRemoteDataSource.getMoviesFromApi()
            val body = response.body()
            if (body != null) {
                moviesList = body.results
            }
        } catch (exception: Exception) {
            Log.i("MyTag", "Exception: ${exception.message.toString()}")
        }
        return moviesList
    }

    private suspend fun getMoviesFromLocalDataSource(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            moviesList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.isNotEmpty()) {
            return moviesList
        } else {
            moviesList = getMoviesFromRemoteDataSource()
            movieLocalDataSource.saveMovies(moviesList)
        }
        return moviesList
    }

    private suspend fun getMoviesFromCacheDataSource(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            moviesList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.isNotEmpty()) {
            return moviesList
        } else {
            moviesList = getMoviesFromLocalDataSource()
            movieCacheDataSource.saveMovies(moviesList)
        }
        return moviesList
    }

}