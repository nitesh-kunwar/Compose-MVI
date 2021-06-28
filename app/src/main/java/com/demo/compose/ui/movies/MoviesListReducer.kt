package com.demo.compose.ui.movies

import com.demo.compose.data.models.movie.ApiResponse
import com.demo.compose.data.models.movie.MovieModel
import kotlinx.coroutines.flow.MutableStateFlow


suspend fun MoviesListViewModel.reduceUserIntents(
    _uiState: MutableStateFlow<MoviesListViewState>,
    userIntents: UserIntents
) {
    when(userIntents){
        is UserIntents.OnTextChanged ->{
            if(userIntents.text.trim().isEmpty()) {
                _uiState.value = _uiState.value.copy(movies = null, searchString = userIntents.text)
            }else{
                _uiState.value = _uiState.value.copy(searchString = userIntents.text)
                getSearchedMovies(userIntents.text.trim())
            }
        }
    }
}


fun reduceMoviesResponse(_uiState: MutableStateFlow<MoviesListViewState>, it: ApiResponse<MovieModel>) {
    it.data?.let {
        _uiState.value = _uiState.value.copy(movies = it.d)
    }

}