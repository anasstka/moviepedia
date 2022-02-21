package com.anasstka.moviepedia.presentation.movies

import com.anasstka.moviepedia.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
