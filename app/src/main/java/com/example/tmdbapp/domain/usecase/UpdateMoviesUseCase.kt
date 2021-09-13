package com.example.tmdbapp.domain.usecase

import com.example.tmdbapp.data.model.movie.Movie
import com.example.tmdbapp.domain.repository.MovieRepository
import javax.inject.Inject

class UpdateMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}