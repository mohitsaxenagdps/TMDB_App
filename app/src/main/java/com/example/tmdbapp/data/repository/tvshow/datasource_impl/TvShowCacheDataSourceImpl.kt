package com.example.tmdbapp.data.repository.tvshow.datasource_impl

import com.example.tmdbapp.data.model.tvshow.TvShow
import com.example.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowsList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> = tvShowsList

    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}