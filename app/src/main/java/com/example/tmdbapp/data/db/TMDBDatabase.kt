package com.example.tmdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbapp.data.model.movie.Movie
import com.example.tmdbapp.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

}