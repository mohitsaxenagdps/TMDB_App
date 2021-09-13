package com.example.tmdbapp.data.repository.tvshow.datasource_impl

import com.example.tmdbapp.data.db.TvShowDao
import com.example.tmdbapp.data.model.tvshow.TvShow
import com.example.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShows(tvShowsList: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTvShows(tvShowsList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}