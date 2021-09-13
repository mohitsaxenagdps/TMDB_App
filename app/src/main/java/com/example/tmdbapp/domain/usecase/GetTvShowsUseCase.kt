package com.example.tmdbapp.domain.usecase

import com.example.tmdbapp.data.model.tvshow.TvShow
import com.example.tmdbapp.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()

}