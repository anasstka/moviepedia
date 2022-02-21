package com.anasstka.moviepedia.domain.use_case

import com.anasstka.moviepedia.common.Resource
import com.anasstka.moviepedia.data.network.dto.toMovie
import com.anasstka.moviepedia.domain.model.Movie
import com.anasstka.moviepedia.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
//        try {
        emit(Resource.Loading<List<Movie>>())
        val response = repository.getMovies()
        if (response.isSuccessful) {
            val movies = response.body()?.let { resultResponse ->
                resultResponse.results.map { it.toMovie() }
            }
            emit(Resource.Success<List<Movie>>(movies))
        }
        else
        {
            emit(Resource.Error<List<Movie>>(response.message()))
        }
//        } catch(e: HttpException) {
//            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
//        } catch(e: IOException) {
//            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
//        }
    }
}