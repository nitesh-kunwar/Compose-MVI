package com.demo.compose.ui.movies

import com.demo.compose.data.models.movie.D

data class MoviesListViewState(
    val movies:List<D>? = null,
    val searchString: String = ""

)


sealed class UserIntents{
    data class OnTextChanged(val text:String):UserIntents()
    class SearchMovie: UserIntents()

}