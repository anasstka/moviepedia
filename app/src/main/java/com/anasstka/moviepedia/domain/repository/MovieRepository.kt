package com.anasstka.moviepedia.domain.repository

import com.anasstka.moviepedia.data.network.dto.CastDto
import com.anasstka.moviepedia.data.network.dto.MovieDto
import com.anasstka.moviepedia.data.network.dto.MovieListDto
import com.anasstka.moviepedia.domain.model.Movie
import retrofit2.Response

interface MovieRepository {

    suspend fun getMovies(): Response<MovieListDto>

    suspend fun searchMovies(query: String): Response<List<MovieDto>>

    suspend fun getCast(movie: Movie): Response<List<CastDto>>
}