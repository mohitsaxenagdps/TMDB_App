package com.example.tmdbapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.tmdbapp.data.api.TMDBService
import com.example.tmdbapp.data.db.MovieDao
import com.example.tmdbapp.data.db.TMDBDatabase
import com.example.tmdbapp.data.db.TvShowDao
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
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }

    @Provides
    @Singleton
    fun provideTMDBDatabase(@ApplicationContext context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowDao()
    }

}