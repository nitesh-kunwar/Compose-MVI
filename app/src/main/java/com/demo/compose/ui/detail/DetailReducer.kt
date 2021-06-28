package com.demo.compose.ui.detail

import kotlinx.coroutines.flow.MutableStateFlow

fun DetailViewModel.reduceUserIntent(_uiState: MutableStateFlow<DetailViewState>, it: UserIntents) {
    when (it) {
        is UserIntents.ParseBundle -> {
         it.bundle?.let {
             if(it.containsKey("data")){
                 _uiState.value = _uiState.value.copy(movieData = it.getParcelable("data"))
             }
         }
        }
    }
}