package com.anasstka.moviepedia.di

import com.anasstka.moviepedia.common.Constants
import com.anasstka.moviepedia.data.network.MovieApi
import com.anasstka.moviepedia.data.repository.MovieRepositoryImpl
import com.anasstka.moviepedia.domain.repository.MovieRepository
import com.anasstka.moviepedia.domain.use_case.GetMoviesUseCase
import com.anasstka.moviepedia.domain.use_case.MovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesMoviesUseCases(repository: MovieRepository): MovieUseCases {
        return MovieUseCases(
            getMovies = GetMoviesUseCase(repository)
        )
    }
}