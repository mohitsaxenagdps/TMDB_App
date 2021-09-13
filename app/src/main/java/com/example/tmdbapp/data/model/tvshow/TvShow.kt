package com.example.tmdbapp.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_tv_shows")
data class TvShow(
    @PrimaryKey
    val id: Int,
    val backdrop_path: String,
    val first_air_date: String,
    val name: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)