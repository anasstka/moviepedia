package com.anasstka.moviepedia.data.network

import com.anasstka.moviepedia.common.Constants
import com.anasstka.moviepedia.data.network.dto.CastDto
import com.anasstka.moviepedia.data.network.dto.MovieDto
import com.anasstka.moviepedia.data.network.dto.MovieListDto
import retrofit2.Response
import retrofit2.http.*

interface MovieApi {

//    @GET("/authentication/token/new")
//    suspend fun getToken(
//        @Query("api_key")
//        apiKey: String = Common.API_KEY
//    ): Response<Token>
//
//    @GET("/{request_token}")
//    suspend fun authenticationUser(
//        @Path("request_token")
//        token: String
//    )
//
//    @POST("/authentication/session/new")
//    suspend fun getSession(
//        @Body
//        token: Token,
//        @Query("api_key")
//        apiKey: String = Common.API_KEY
//    ): Response<Session>
//
//    @DELETE("/authentication/session")
//    suspend fun deleteSession(
//        @Body
//        session: Session,
//        @Query("api_key")
//        apiKey: String = Common.API_KEY
//    )

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key")
        apiKey: String = Constants.API_KEY,
        @Query("language")
        language: String = "ru-RU",
        @Query("sort_by")
        sortBy: String = "popularity.desc",
        @Query("include_adult")
        includeAdult: Boolean = false,
        @Query("include_video")
        includeVideo: Boolean = false,
        @Query("page")
        page: Int = 1,
        @Query("with_watch_monetization_types")
        withMatchMonetizationTypes: String = "flatrate"
    ): Response<MovieListDto>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query")
        query: String,
        @Query("api_key")
        apiKey: String = Constants.API_KEY,
        @Query("language")
        language: String = "ru-RU",
        @Query("page")
        page: Int = 1,
        @Query("include_adult")
        includeAdult: Boolean = false,
    ): Response<List<MovieDto>>

    @GET("movie/{movie_id}/credits")
    suspend fun getCast(
        @Path("movie_id")
        movieId: Int,
        @Query("api_key")
        apiKey: String = Constants.API_KEY,
        @Query("language")
        language: String = "ru-RU"
    ): Response<List<CastDto>>

//    suspend fun getFavoriteMovies(
//        movie: Movie
//    ): Response<List<Movie>>
//
//    suspend fun addFavoriteMovies(
//        movie: Movie
//    )
}