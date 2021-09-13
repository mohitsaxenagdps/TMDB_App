package com.example.tmdbapp.data.api

import androidx.viewbinding.BuildConfig
import com.example.tmdbapp.BuildConfig.API_KEY
import com.example.tmdbapp.data.model.movie.MovieList
import com.example.tmdbapp.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String = API_KEY): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String = API_KEY): Response<TvShowList>

}