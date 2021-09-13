package com.example.tmdbapp.data.repository.tvshow

import android.util.Log
import com.example.tmdbapp.data.model.tvshow.TvShow
import com.example.tmdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbapp.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowFromCacheDataSource()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowFromRemoteDataSource()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShows(newListOfTvShows)
        tvShowCacheDataSource.saveTvShows(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowFromRemoteDataSource(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShowFromApi()
            val body = response.body()
            if (body != null) {
                tvShowList = body.results
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    private suspend fun getTvShowFromLocalDataSource(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromRemoteDataSource()
            tvShowLocalDataSource.saveTvShows(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowFromCacheDataSource(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromLocalDataSource()
            tvShowCacheDataSource.saveTvShows(tvShowList)
        }
        return tvShowList
    }

}