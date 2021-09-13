package com.example.tmdbapp.data.repository.tvshow.datasource

import com.example.tmdbapp.data.model.movie.Movie
import com.example.tmdbapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShows(tvShows: List<TvShow>)

}