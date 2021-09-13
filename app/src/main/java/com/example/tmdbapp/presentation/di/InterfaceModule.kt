package com.example.tmdbapp.presentation.di

import com.example.tmdbapp.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbapp.data.repository.movie.datasource_impl.MovieCacheDataSourceImpl
import com.example.tmdbapp.data.repository.movie.datasource_impl.MovieLocalDataSourceImpl
import com.example.tmdbapp.data.repository.movie.datasource_impl.MovieRemoteDataSourceImpl
import com.example.tmdbapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {

    @Binds
    @Singleton
    abstract fun bindingMovieRepo(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    @Singleton
    abstract fun bindingMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindingMovieLocalDataSource(movieLocalDataSourceImpl: MovieLocalDataSourceImpl): MovieLocalDataSource

    @Binds
    @Singleton
    abstract fun bindingMovieCacheDataSource(movieCacheDataSourceImpl: MovieCacheDataSourceImpl): MovieCacheDataSource

}