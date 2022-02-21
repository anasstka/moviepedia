package com.anasstka.moviepedia.presentation.movies

import com.anasstka.moviepedia.domain.model.Movie

sealed class MoviesEvent {
    data class AddFavoriteMovie(val movie: Movie) : MoviesEvent()
    object GetMovies : MoviesEvent()
}