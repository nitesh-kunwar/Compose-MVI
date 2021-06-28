package com.demo.compose.ui.detail

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DetailViewState())

    val uiState: StateFlow<DetailViewState> = _uiState

    val userIntentChannel = Channel<UserIntents>()

    init {
        viewModelScope.launch {
            userIntentChannel.consumeAsFlow().collect {
                reduceUserIntent(_uiState,it)
            }
        }
    }




}