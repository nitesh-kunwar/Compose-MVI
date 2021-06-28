package com.demo.compose.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MoviesListViewModel : ViewModel() {

    private val repo = MoviesListRepo()

    private val _uiState = MutableStateFlow(MoviesListViewState())

    val uiState: StateFlow<MoviesListViewState> = _uiState

    val userIntentChannel = Channel<UserIntents>()

    init {
        viewModelScope.launch {

            handleUserIntents()
        }
    }

    private suspend fun handleUserIntents() {
        userIntentChannel.consumeAsFlow().collect {
                        reduceUserIntents(_uiState,it)
        }

    }


    suspend fun getSearchedMovies(text: String) {
        viewModelScope.launch {
            repo.searchMovie(text).collect{
                reduceMoviesResponse(_uiState,it)
            }
        }

    }




}