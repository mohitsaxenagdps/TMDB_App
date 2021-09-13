package com.example.tmdbapp.domain.repository

import com.example.tmdbapp.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}