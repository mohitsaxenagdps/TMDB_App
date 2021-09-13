package com.example.tmdbapp.data.model.tvshow

import com.example.tmdbapp.data.model.tvshow.TvShow

data class TvShowList(
    val page: Int,
    val results: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)