package com.example.tmdbapp.data.repository.tvshow.datasource

import com.example.tmdbapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShowFromApi(): Response<TvShowList>

}