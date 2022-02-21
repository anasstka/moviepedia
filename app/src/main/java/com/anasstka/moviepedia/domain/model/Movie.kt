package com.anasstka.moviepedia.domain.model

data class Movie(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val poster: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double
)
