package com.anasstka.moviepedia.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anasstka.moviepedia.common.Resource
import com.anasstka.moviepedia.domain.use_case.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
) : ViewModel() {

    private val _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state

    init {
        getMovies()
    }

    fun onEvent(event: MoviesEvent) {
        when (event) {
            is MoviesEvent.GetMovies -> {
                getMovies()
            }
            is MoviesEvent.AddFavoriteMovie -> {

            }
        }
    }

    private fun getMovies() {
        movieUseCases.getMovies().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MoviesState(
                        movies = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = MoviesState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MoviesState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}