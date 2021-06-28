package com.demo.compose.ui.movies

import com.demo.compose.data.models.movie.D

data class MoviesListViewState(
    val movies:List<D>? = null,
    val searchString: String = "",
    val isLoading:Boolean = false,
    val screenState: ScreenState = ScreenState.Idle

)

sealed class UserIntents{
    data class OnTextChanged(val text:String):UserIntents()
    object SearchMovie: UserIntents()
    object ResetScreenState: UserIntents()
    data class OpenDetailScreen(val data:D):UserIntents()

}

sealed class ScreenState{
    object Idle:ScreenState()
    data class OpenDetailScreen(val data:D):ScreenState()
}