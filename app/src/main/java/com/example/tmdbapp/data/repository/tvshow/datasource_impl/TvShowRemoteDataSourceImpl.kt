package com.example.tmdbapp.data.repository.tvshow.datasource_impl

import com.example.tmdbapp.data.api.TMDBService
import com.example.tmdbapp.data.model.tvshow.TvShowList
import com.example.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apikey: String):
    TvShowRemoteDataSource {
    override suspend fun getTvShowFromApi(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apikey)
    }
}