package com.demo.compose.ui.movies

import com.demo.compose.data.models.movie.ApiResponse
import com.demo.compose.data.models.movie.MovieModel
import kotlinx.coroutines.flow.MutableStateFlow


suspend fun MoviesListViewModel.reduceUserIntents(
    _uiState: MutableStateFlow<MoviesListViewState>,
    userIntents: UserIntents
) {
    when (userIntents) {
        is UserIntents.OnTextChanged -> {
            if (userIntents.text.trim().isEmpty()) {
                _uiState.value = _uiState.value.copy(
                    movies = null,
                    searchString = userIntents.text,
                )
            } else {
                _uiState.value = _uiState.value.copy(searchString = userIntents.text)
            }
        }
        is UserIntents.SearchMovie -> {
            if (_uiState.value.searchString.trim().isNotEmpty()) {
                _uiState.value = _uiState.value.copy(isLoading = true)
                getSearchedMovies(_uiState.value.searchString)
            }
        }
        is UserIntents.OpenDetailScreen -> {
            _uiState.value = _uiState.value.copy(screenState = ScreenState.OpenDetailScreen(userIntents.data))
        }
        is UserIntents.ResetScreenState -> {
            _uiState.value = _uiState.value.copy(screenState = ScreenState.Idle)
        }
    }
}


fun reduceMoviesResponse(
    _uiState: MutableStateFlow<MoviesListViewState>,
    it: ApiResponse<MovieModel>
) {
    it.data?.let {
        _uiState.value = _uiState.value.copy(movies = it.d, isLoading = false)
    }

}