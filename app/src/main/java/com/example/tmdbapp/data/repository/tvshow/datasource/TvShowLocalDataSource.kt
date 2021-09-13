package com.example.tmdbapp.data.repository.tvshow.datasource

import com.example.tmdbapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShows(tvShowsList: List<TvShow>)
    suspend fun clearAll()

}