package com.demo.compose.ui.detail

import android.os.Bundle
import com.demo.compose.data.models.movie.D

data class DetailViewState(
    val movieData: D?=null
)

sealed class UserIntents{
    data class ParseBundle(val bundle: Bundle?):UserIntents()
}