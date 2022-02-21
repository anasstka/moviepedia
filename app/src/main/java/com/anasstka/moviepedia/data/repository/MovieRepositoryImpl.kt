package com.anasstka.moviepedia.data.repository

import com.anasstka.moviepedia.data.network.MovieApi
import com.anasstka.moviepedia.data.network.dto.CastDto
import com.anasstka.moviepedia.data.network.dto.MovieDto
import com.anasstka.moviepedia.data.network.dto.MovieListDto
import com.anasstka.moviepedia.domain.model.Cast
import com.anasstka.moviepedia.domain.model.Movie
import com.anasstka.moviepedia.domain.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getMovies(): Response<MovieListDto> =
        api.getMovies()

    override suspend fun searchMovies(query: String): Response<List<MovieDto>> =
        api.searchMovies(query)

    override suspend fun getCast(movie: Movie): Response<List<CastDto>> =
        api.getCast(movie.id)
}