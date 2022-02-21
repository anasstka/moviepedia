package com.anasstka.moviepedia.data.network.dto

import com.anasstka.moviepedia.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("backdrop_path")
    val poster: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)

fun MovieDto.toMovie(): Movie =
    Movie(
        id = id,
        originalTitle = originalTitle,
        overview = overview,
        poster = poster,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage
    )